package com.lam.tms.service;

import com.github.pagehelper.PageInfo;
import com.lam.tms.common.jwt.JwtUser;
import com.lam.tms.common.service.BaseService;
import com.lam.tms.entity.SysUser;
import com.lam.tms.util.QueryParameter;
import com.lam.tms.vo.SysUserVo;
import com.lam.tms.vo.UserVo;
import org.springframework.security.core.AuthenticationException;


/**
 * 用户Service
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */

public interface SysUserService extends BaseService<SysUser, Integer> {


    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return String token 值
     * @throws AuthenticationException
     */
    String login(String username, String password) throws AuthenticationException;


    SysUser findUser(SysUser user);
    /**
     * 校验登录的用户中，用户名，是否正确
     *
     * @param username 用户名
     * @return 操作结果
     * @throws AuthenticationException
     */
    JwtUser validateUsername(String username);


    /**
     * 获取用户详细信息
     *
     * @return UserVo
     */
    UserVo findUserInfo();


    /**
     * 分页 获取用户详细信息
     * @param parameter
     * @return PageInfo<SysUserVo>
     */
    PageInfo<SysUserVo> findAllPageInfo(QueryParameter parameter);

}
