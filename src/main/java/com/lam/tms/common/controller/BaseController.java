package com.lam.tms.common.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lam.tms.common.domain.BaseEntity;
import com.lam.tms.common.service.BaseService;
import com.lam.tms.util.JsonResult;
import com.lam.tms.util.QueryParameter;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 通用的  增 , 删 , 改 , 查所有 , Id查询 , 分页 控制器
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */


@Slf4j
public class BaseController<T extends BaseEntity, ID, S extends BaseService<T, ID>> {

    @Autowired
    protected S baseService;

    @ApiOperation(value = "单个查询", notes = "根据Id查询")
    @GetMapping("/{id}")
    public JsonResult<T> findById(@PathVariable("id") ID id) {
        log.info("get ID : {}", id);
        return JsonResult.success(baseService.findById(id));
    }

    @ApiOperation(value = "查询所有", notes = "查询所有")
    @GetMapping("/all")
    public JsonResult<List<T>> findAll() {
        return JsonResult.success(baseService.findAll(null));
    }

    @ApiOperation(value = "分页", notes = "分页 查询所有")
    @GetMapping("/page")
    public JsonResult<Page<T>> findAll(QueryParameter parameter) {
        PageInfo<T> page = baseService.findAllPage(parameter);
        return JsonResult.success(page.getTotal(), parameter.getPageNum(), page.getList());
    }

    @ApiOperation(value = "新增", notes = "不需要添加id")
    @PostMapping()
    public JsonResult<T> create(@RequestBody T entity) {
        return JsonResult.success(baseService.create(entity));
    }

    @ApiOperation(value = "修改", notes = "修改必须要id")
    @PutMapping()
    public JsonResult<T> update(@RequestBody T entity) {
        log.info("update:  {}", entity);
        return JsonResult.success(baseService.update(entity));
    }

    @ApiOperation(value = "删除", notes = "只需要id即可")
    @DeleteMapping("/{id}")
    public JsonResult<String> delete(@PathVariable("id") ID id) {
        return JsonResult.success(baseService.deleteById(id));
    }

}
