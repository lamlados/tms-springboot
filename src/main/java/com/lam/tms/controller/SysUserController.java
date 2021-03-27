package com.lam.tms.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lam.tms.common.controller.BaseController;
import com.lam.tms.entity.SysUser;
import com.lam.tms.service.SysUserService;
import com.lam.tms.util.JsonResult;
import com.lam.tms.util.QueryParameter;
import com.lam.tms.vo.SysUserVo;
import com.lam.tms.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;


/**
 * 用户管理 控制器
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */


@Slf4j
@Api(tags = "[ 权限管理 ] 用户信息")
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends BaseController<SysUser, Integer, SysUserService> {

    @Autowired
    @Lazy
    private RedisTemplate<String, String> redisTemplate;

    @ApiOperation(value = "分页,获取用户详情", notes = "分页 查询所有，获取用户详情")
    @GetMapping("/info/page")
    public JsonResult<Page<SysUserVo>> findAllInfoPage(QueryParameter parameter) {
        PageInfo<SysUserVo> page = baseService.findAllPageInfo(parameter);
        return JsonResult.success(page.getTotal(), parameter.getPageNum(), page.getList());
    }

    @ApiOperation(value = "获取用户详细信息", notes = "获取用户详细信息")
    @GetMapping("/info")
    public JsonResult<UserVo> findUserInfo() {
        UserVo userInfo = baseService.findUserInfo();
        String currentItem = redisTemplate.opsForValue().get(userInfo.getUsername());
        userInfo.setCurrentItem(currentItem);
        return JsonResult.success(userInfo);
    }



    @ApiOperation(value = "注销", notes = "注销")
    @GetMapping("/logout")
    public JsonResult<UserVo> findUserInfo(String wtf) {
        UserVo userInfo = baseService.findUserInfo();
        return JsonResult.success(userInfo);
    }



}
