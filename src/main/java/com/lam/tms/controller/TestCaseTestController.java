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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(tags = "[ 业务内容 ] 测试用例测试管理")
@RestController
@RequestMapping("/system/result")
public class TestCaseTestController {
    @Autowired
    private TestCaseTestService testCaseTestService;

    @ApiOperation(value = "全部查询", notes = "测试用例测试全部查询")
    @GetMapping("/all")
    public JsonResult<PageInfo<TestCaseDesign>> getAllList(PageVo pageVo, String caseMark){
        PageHelper.startPage(pageVo.getPageNum(), pageVo.getPageSize());
        return null;
    }


    @ApiOperation(value = "根据ID更新", notes = "根据ID更新测试用例测试")
    @PostMapping("/update")
    public JsonResult<Integer> updateById(@RequestBody String json){
        TestCaseTest testCaseTest = JsonUtils.jsonToPojo(json, TestCaseTest.class);
        int result = testCaseTestService.updateCase(testCaseTest);
        return JsonResult.success(result);
    }

}
