package com.lam.tms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lam.tms.entity.TestCaseDesign;
import com.lam.tms.service.TestCaseDesignService;
import com.lam.tms.util.JsonResult;
import com.lam.tms.util.JsonUtils;
import com.lam.tms.vo.PageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户管理 控制器
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */

@Slf4j
@Api(tags = "[ 业务内容 ] 测试项目管理")
@RestController
@RequestMapping("/system/item")
public class TestCaseDesignController {
    @Autowired
    private TestCaseDesignService testCaseDesignService;


    @ApiOperation(value = "分页查询", notes = "分页查询")
    @PostMapping("/pageInfo")
    public JsonResult<PageInfo<TestCaseDesign>> getPageInfo(PageVo pageVo){
        PageHelper.startPage(pageVo.getPageNum(), pageVo.getPageSize());
        List<TestCaseDesign> list = testCaseDesignService.getAllList();
        PageInfo<TestCaseDesign> pageInfo = new PageInfo<TestCaseDesign>(list);
        return JsonResult.success(pageInfo);
    }

    @ApiOperation(value = "全部查询", notes = "全部查询")
    @GetMapping("/all")
    public JsonResult<PageInfo<TestCaseDesign>> getAllList(PageVo pageVo, String caseMark){
        PageHelper.startPage(pageVo.getPageNum(), pageVo.getPageSize());
        if(caseMark==null){
            List<TestCaseDesign> list = testCaseDesignService.getAllList();
            PageInfo<TestCaseDesign> pageInfo = new PageInfo<TestCaseDesign>(list);
            return JsonResult.success(pageInfo);
        }else{
            List<TestCaseDesign> list = testCaseDesignService.getListByMark(caseMark);
            PageInfo<TestCaseDesign> pageInfo = new PageInfo<TestCaseDesign>(list);
            return JsonResult.success(pageInfo);
        }
    }

//    @ApiOperation(value = "根据ID更新", notes = "根据ID更新")
//    @PostMapping("/update")
//    public JsonResult<Integer> updateById(@RequestBody String json){
//        TestCaseDesign testCaseDesign = JsonUtils.jsonToPojo(json, TestCaseDesign.class);
//        System.out.println(testCaseDesign);
//        int result = testCaseDesignService.updateById(testCaseDesign.getId());
//        return JsonResult.success(result);
//    }

    @ApiOperation(value = "根据ID删除", notes = "根据ID删除")
    @PostMapping("/delete")
    public JsonResult<Integer> deleteById(Integer id){
        int result = testCaseDesignService.deleteById(id);
        return JsonResult.success(result);
    }
}

