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
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lamlados
 * @date 2021/2/28 22:57
 */
@Slf4j
@Api(tags = "[ 业务内容 ] 问题管理")
@RestController
@RequestMapping("/system/bug")
public class ProbelmDescriptionController {
    @Autowired
    private ProblemDescriptionService problemDescriptionService;
    @ApiOperation(value = "分页查询", notes = "问题分页查询")
    @PostMapping("/pageInfo")
    public JsonResult<PageInfo<TestCaseDesign>> getPageInfo(PageVo pageVo){
        PageHelper.startPage(pageVo.getPageNum(), pageVo.getPageSize());
        List<ProblemDescription> list = problemDescriptionService.getAllList();
        PageInfo<ProblemDescription> pageInfo = new PageInfo<ProblemDescription>(list);
        return JsonResult.success(pageInfo);
    }

    @ApiOperation(value = "全部查询", notes = "问题全部查询")
    @GetMapping("/all")
    public JsonResult<PageInfo<ProblemDescription>> getAllList(PageVo pageVo, String problemMark){
        PageHelper.startPage(pageVo.getPageNum(), pageVo.getPageSize());
        if(problemMark==null){
            List<ProblemDescription> list = problemDescriptionService.getAllList();
            PageInfo<ProblemDescription> pageInfo = new PageInfo<ProblemDescription>(list);
            return JsonResult.success(pageInfo);
        }else{
            List<ProblemDescription> list = problemDescriptionService.getListByMark(problemMark);
            PageInfo<ProblemDescription> pageInfo = new PageInfo<ProblemDescription>(list);
            return JsonResult.success(pageInfo);
        }
    }
}
