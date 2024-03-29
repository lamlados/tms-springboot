package com.lam.tms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lam.tms.entity.TestCaseDesign;
import com.lam.tms.service.TestCaseDesignService;
import com.lam.tms.util.JsonResult;
import com.lam.tms.util.JsonUtils;
import com.lam.tms.vo.PageVo;
import com.lam.tms.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 用户管理 控制器
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */

@Slf4j
@Api(tags = "[ 业务内容 ] 测试用例设计管理")
@RestController
@RequestMapping("/system/item")
public class TestCaseDesignController {

    @Autowired
    private TestCaseDesignService testCaseDesignService;

    @Autowired
    @Lazy
    private RedisTemplate<String, String> redisTemplate;

    @ApiOperation(value = "分页查询", notes = "测试用例分页查询")
    @PostMapping("/pageInfo")
    public JsonResult<PageInfo<TestCaseDesign>> getPageInfo(PageVo pageVo) {
        PageHelper.startPage(pageVo.getPageNum(), pageVo.getPageSize());
        List<TestCaseDesign> list = testCaseDesignService.getAllList();
        PageInfo<TestCaseDesign> pageInfo = new PageInfo<TestCaseDesign>(list);
        return JsonResult.success(pageInfo);
    }

    @ApiOperation(value = "全部查询", notes = "测试用例全部查询")
    @GetMapping("/all")
    public JsonResult<PageInfo<TestCaseDesign>> getAllList(PageVo pageVo, String caseMark) {
        PageHelper.startPage(pageVo.getPageNum(), pageVo.getPageSize());
        if (caseMark == null) {
            List<TestCaseDesign> list = testCaseDesignService.getAllList();
            PageInfo<TestCaseDesign> pageInfo = new PageInfo<TestCaseDesign>(list);
            return JsonResult.success(pageInfo);
        } else {
            List<TestCaseDesign> list = testCaseDesignService.getListByMark(caseMark);
            PageInfo<TestCaseDesign> pageInfo = new PageInfo<TestCaseDesign>(list);
            return JsonResult.success(pageInfo);
        }
    }

    @ApiOperation(value = "根据ID更新", notes = "根据ID更新测试用例")
    @PostMapping("/update")
    public JsonResult<Integer> updateById(@RequestBody String json) {
        TestCaseDesign testCaseDesign = JsonUtils.jsonToPojo(json, TestCaseDesign.class);
        String testDescription = redisTemplate.opsForValue().get("testDescription");
        String s = testDescription.replaceAll("E:/static", "http://localhost:8090/image");
        testCaseDesign.setTestDescription(s);
        int result = testCaseDesignService.updateCase(testCaseDesign);
        return JsonResult.success(result);
    }

    @ApiOperation(value = "新增用例", notes = "新增测试用例")
    @PostMapping("/add")
    public JsonResult<Integer> createCase(@RequestBody String json) {
        TestCaseDesign testCaseDesign = JsonUtils.jsonToPojo(json, TestCaseDesign.class);
        String testDescription = redisTemplate.opsForValue().get("testDescription");
        String s = testDescription.replaceAll("E:/static", "http://localhost:8090/image");
        testCaseDesign.setTestDescription(s);
        int result = testCaseDesignService.createCase(testCaseDesign);
        return JsonResult.success(result);
    }

    @ApiOperation(value = "根据ID删除", notes = "根据ID删除测试用例")
    @PostMapping("/delete")
    public JsonResult<Integer> deleteById(Integer id) {
        int result = testCaseDesignService.deleteById(id);
        return JsonResult.success(result);
    }

    @ApiOperation(value = "切换项目", notes = "切换项目")
    @PostMapping("/switchItem")
    public JsonResult<UserVo> switchItem(String user, String currentItem) {
        redisTemplate.opsForValue().set(user, currentItem, 10, TimeUnit.MINUTES);
        return JsonResult.success("切换成功");
    }

    @ApiOperation(value = "图片上传", notes = "图片上传")
    @PostMapping("/uploadPic")
    public JsonResult<Integer> uploadPic(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        int length = originalFilename.length();
        String finalFilename = originalFilename.substring(0, length - 4);
        String picUrl = "E:/static/" + finalFilename + ".png";
        File f = new File(picUrl);
        file.transferTo(f);
        redisTemplate.opsForValue().set("testDescription", picUrl, 10, TimeUnit.MINUTES);
        return JsonResult.success("上传成功");
    }

}

