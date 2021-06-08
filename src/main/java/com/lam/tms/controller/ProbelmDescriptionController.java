package com.lam.tms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lam.tms.entity.ProblemDescription;
import com.lam.tms.entity.TestCaseDesign;
import com.lam.tms.service.ProblemDescriptionService;
import com.lam.tms.util.JsonResult;
import com.lam.tms.util.JsonUtils;
import com.lam.tms.vo.PageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
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

    @Autowired
    @Lazy
    private RedisTemplate<String, String> redisTemplate;

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


    @ApiOperation(value = "添加问题", notes = "添加问题")
    @PostMapping("/add")
    public JsonResult<Integer> createCase(@RequestBody String json){
        ProblemDescription problemDescription = JsonUtils.jsonToPojo(json, ProblemDescription.class);
        int result = problemDescriptionService.createCase(problemDescription);
        return JsonResult.success(result);
    }

    @ApiOperation(value = "根据ID更新", notes = "根据ID更新问题")
    @PostMapping("/update")
    public JsonResult<Integer> updateById(@RequestBody String json){
        ProblemDescription problemDescription = JsonUtils.jsonToPojo(json, ProblemDescription.class);
        int result = problemDescriptionService.updateProblem(problemDescription);
        return JsonResult.success(result);
    }

    @ApiOperation(value = "根据ID删除", notes = "根据ID删除问题")
    @PostMapping("/delete")
    public JsonResult<Integer> deleteById(Integer id){
        int result = problemDescriptionService.deleteById(id);
        return JsonResult.success(result);
    }

    @ApiOperation(value = "标识生成", notes = "生成当前问题的标识")
    @PostMapping("/generateMark")
    public JsonResult<Integer> generateMark() {
        String caseNumber = redisTemplate.opsForValue().get("tctCaseMark");
        String itemMark = redisTemplate.opsForValue().get("tctItemMark");
        String problemMark = redisTemplate.opsForValue().get("originProblemMark");
        int result = problemDescriptionService.checkMark(problemMark);

        String[] marks = {itemMark, caseNumber, problemMark+"-B-"+(result+1)};
        return JsonResult.success(marks);
    }
}
