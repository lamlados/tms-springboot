package com.lam.tms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lam.tms.entity.TestCaseDesign;
import com.lam.tms.service.TestCaseDesignService;
import com.lam.tms.util.JsonResult;
import com.lam.tms.vo.PageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/system")
public class TestCaseDesignController {
    @Autowired
    private TestCaseDesignService testCaseDesignService;

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @PostMapping("/item/pageInfo")
    @ResponseBody
    public JsonResult<PageInfo<TestCaseDesign>> getPageInfo(PageVo pageVo){
        PageHelper.startPage(pageVo.getPageNum(), pageVo.getPageSize());
        List<TestCaseDesign> list = testCaseDesignService.getTestCaseDesignList();
        PageInfo<TestCaseDesign> pageInfo = new PageInfo<TestCaseDesign>(list);
        return JsonResult.success(pageInfo);
    }
}

