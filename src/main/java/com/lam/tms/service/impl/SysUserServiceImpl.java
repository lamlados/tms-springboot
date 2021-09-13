package com.lam.tms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lam.tms.common.jwt.JwtTokenUtils;
import com.lam.tms.common.jwt.JwtUser;
import com.lam.tms.common.service.impl.BaseServiceImpl;
import com.lam.tms.entity.SysUser;
import com.lam.tms.mapper.SysUserMapper;
import com.lam.tms.service.SysUserService;
import com.lam.tms.util.QueryParameter;
import com.lam.tms.vo.SysUserVo;
import com.lam.tms.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 用户Service 实现类
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */

@Slf4j
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, Integer, SysUserMapper> implements SysUserService {

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteById(Integer id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    @Lazy
    private RedisTemplate<String, Object> redisTemplate;

    private BoundHashOperations<String, String, Object> tokenStorage() {
        return redisTemplate.boundHashOps(jwtTokenUtils.getTokenHeader());
    }

    /**
     * @describe 登录表单获取 Token
     * @date 2021/2/22
     * @author lamlados
     */
    @Override
    public String login(String username, String password) throws AuthenticationException {
        // 把表单提交的 username  password 封装到 UsernamePasswordAuthenticationToken中
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        JwtUser userDetails = (JwtUser) userDetailsService.loadUserByUsername(username);
        String token = jwtTokenUtils.generateToken(userDetails);
        log.info("userDetails: {}", userDetails);
        tokenStorage().put(userDetails.getUsername(), userDetails);
        return token;
    }

    @Override
    public SysUser findUser(SysUser user) {
        return userMapper.findByUsername(user.getUsername());
    }

    @Override
    public JwtUser validateUsername(String username) {
        return (JwtUser) tokenStorage().get(username);
    }

    @Override
    public UserVo findUserInfo() {
        // 从SecurityContextHolder中获取到，当前登录的用户信息。
        JwtUser userDetails = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // 根据用户Id，获取用户详细信息。
        SysUser sysUser = findById(userDetails.getId());
        UserVo result = new UserVo();
        BeanUtils.copyProperties(sysUser, result);
        return result;
    }

    @Override
    public PageInfo<SysUserVo> findAllPageInfo(QueryParameter parameter) {
        log.info("findAll parameter: {}", parameter);
        PageInfo<SysUser> pageInfo = PageHelper
                .startPage(parameter.getPageNum(), parameter.getPageSize())
                .doSelectPageInfo(() -> {
                    if (StringUtils.isEmpty(parameter.getKeywords())) {
                        baseMapper.selectAll();
                    } else {
                        baseMapper.selectByKeywords(parameter.getKeywords());
                    }
                });
        List<SysUserVo> collect = pageInfo.getList().stream()
                .map(res -> {
                    SysUserVo sysUserVo = new SysUserVo();
                    BeanUtils.copyProperties(res, sysUserVo);
                    return sysUserVo;
                }).collect(Collectors.toList());
        PageInfo<SysUserVo> result = new PageInfo<>();
        result.setList(collect);
        result.setTotal(pageInfo.getTotal());
        result.setPageNum(pageInfo.getPageNum());
        return result;
    }

}
