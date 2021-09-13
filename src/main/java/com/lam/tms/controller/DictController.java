package com.lam.tms.controller;

import com.lam.tms.entity.DictQueryItem;
import com.lam.tms.mapper.DictQueryMapper;
import com.lam.tms.util.JsonResult;
import com.lam.tms.vo.DictVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lamlados
 * @date 2021/3/24 12:57
 */
@Slf4j
@Api(tags = "[ 字典管理 ] 通用字典")
@RestController
@RequestMapping("/dict")
public class DictController {

    @Autowired
    private DictQueryMapper dictQueryMapper;

    @ApiOperation(value = "测试项目", notes = "测试项目字典")
    @PostMapping("/testItem")
    public JsonResult<DictVo> getTestItem() {
        List<DictQueryItem> list = dictQueryMapper.getMarkList("测试项目");
        return JsonResult.success(list);
    }

    @ApiOperation(value = "测试能力点", notes = "测试能力点字典")
    @GetMapping("/abilities")
    public JsonResult<DictVo> getAbilities(String currentItem) {
        List<DictQueryItem> list = dictQueryMapper.getAbilityList(currentItem);
        return JsonResult.success(list);
    }

}
