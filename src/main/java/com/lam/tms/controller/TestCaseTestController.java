package com.lam.tms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lam.tms.entity.TestCaseDesign;
import com.lam.tms.entity.TestCaseTest;
import com.lam.tms.service.TestCaseTestService;
import com.lam.tms.util.JsonResult;
import com.lam.tms.util.JsonUtils;
import com.lam.tms.vo.PageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

import java.util.List;

@Slf4j
@Api(tags = "[ 业务内容 ] 测试用例测试管理")
@RestController
@RequestMapping("/system/result")
public class TestCaseTestController {

    @Autowired
    private TestCaseTestService testCaseTestService;

    @Autowired
    @Lazy
    private RedisTemplate<String, String> redisTemplate;

    @ApiOperation(value = "全部查询", notes = "测试用例测试全部查询")
    @GetMapping("/all")
    public JsonResult<PageInfo<TestCaseDesign>> getAllList(PageVo pageVo, String caseMark) {
        PageHelper.startPage(pageVo.getPageNum(), pageVo.getPageSize());
        List<TestCaseTest> list = testCaseTestService.getAllList();
        PageInfo<TestCaseTest> pageInfo = new PageInfo<TestCaseTest>(list);
        return JsonResult.success(pageInfo);
    }

    @ApiOperation(value = "新增用例", notes = "新增测试用例")
    @PostMapping("/add")
    public JsonResult<Integer> createCase(@RequestBody String json) {
        TestCaseTest testCaseTest = JsonUtils.jsonToPojo(json, TestCaseTest.class);
        System.out.println(json);
        String originDatetime = testCaseTest.getExecutionDate();
        String finalDatetime = originDatetime.replace('T', ' ').substring(0, 19);
        System.out.println(finalDatetime);
        testCaseTest.setExecutionDate(finalDatetime);
        int result = testCaseTestService.createCase(testCaseTest);
        return JsonResult.success(result);
    }

    @ApiOperation(value = "根据ID更新", notes = "根据ID更新测试用例测试")
    @PostMapping("/update")
    public JsonResult<Integer> updateById(@RequestBody String json) {
        TestCaseTest testCaseTest = JsonUtils.jsonToPojo(json, TestCaseTest.class);
        String originDatetime = testCaseTest.getExecutionDate();
        String finalDatetime = originDatetime.replace('T', ' ').substring(0, 19);
        testCaseTest.setExecutionDate(finalDatetime);
        int result = testCaseTestService.updateCase(testCaseTest);
        return JsonResult.success(result);
    }

    @ApiOperation(value = "根据ID删除", notes = "根据ID删除测试用例")
    @PostMapping("/delete")
    public JsonResult<Integer> deleteById(Integer id) {
        int result = testCaseTestService.deleteById(id);
        return JsonResult.success(result);
    }

    @ApiOperation(value = "标识记录", notes = "记录当前用例的标识")
    @PostMapping("/recordMark")
    public JsonResult<Integer> recordMark(String caseMark, String problemMark, String itemMark) {
        redisTemplate.opsForValue().set("tctCaseMark", caseMark, 10, TimeUnit.MINUTES);
        redisTemplate.opsForValue().set("tctItemMark", itemMark, 10, TimeUnit.MINUTES);
        redisTemplate.opsForValue().set("originProblemMark", problemMark, 10, TimeUnit.MINUTES);
        return JsonResult.success(1);
    }

    @ApiOperation(value = "标识生成", notes = "生成当前测试的标识")
    @PostMapping("/generateMark")
    public JsonResult<Integer> generateMark() {
        String caseMark = redisTemplate.opsForValue().get("tctCaseMark");
        String itemMark = redisTemplate.opsForValue().get("tctItemMark");
        String[] marks = {itemMark, caseMark};
        return JsonResult.success(marks);
    }

}
