package com.lam.tms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lam.tms.entity.ProblemDescription;
import com.lam.tms.entity.TestCaseDesign;
import com.lam.tms.service.ProblemDescriptionService;
import com.lam.tms.util.JsonResult;
import com.lam.tms.vo.PageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lamlados
 * @date 2021/2/28 22:57
 */
@Slf4j
@Api(tags = "[ 业务内容 ] 问题管理")
@RestController
@RequestMapping("/system")
public class ProbelmDescriptionController {
    @Autowired
    private ProblemDescriptionService problemDescriptionService;
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @PostMapping("/bug/pageInfo")
    @ResponseBody
    public JsonResult<PageInfo<TestCaseDesign>> getPageInfo(PageVo pageVo){
        PageHelper.startPage(pageVo.getPageNum(), pageVo.getPageSize());
        List<ProblemDescription> list = problemDescriptionService.getProblemList();
        PageInfo<ProblemDescription> pageInfo = new PageInfo<ProblemDescription>(list);
        return JsonResult.success(pageInfo);
    }
}
