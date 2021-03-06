package com.lam.tms.common.jwt;

import com.lam.tms.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Jwt核心拦截器
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */


@Slf4j
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
//         获取 Request 中的请求头为 “ Authorization ” 的 token 值
        String completeToken = request.getHeader(this.jwtTokenUtils.getTokenHeader());
        // 验证 值是否以"Bearer "开头
        if (completeToken != null && completeToken.startsWith(this.jwtTokenUtils.getTokenHead())) {
            // 截取token中"Bearer "后面的值，
            final String tokenValue = jwtTokenUtils.interceptCompleteToken(completeToken);
            // 根据 token值，获取 用户的 username
            String username = jwtTokenUtils.getUsernameFromToken(tokenValue);
            log.info("JwtAuthenticationTokenFilter[doFilterInternal] checking authentication {} ", username);
            // 验证用户账号是否合法
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                // 根据username去 redis 中查询user数据，足够信任token的情况下，可以省略这一步
                JwtUser userDetails = sysUserService.validateUsername(username);
                // 再次校验 token 和 登录的用户是否相同
                if (jwtTokenUtils.validateToken(tokenValue, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    // 将用户信息，设置到 SecurityContext 中，可以在任何地方 使用 下面语句获取 获取 当前用户登录信息
                    // JwtUserDetails userDetails = (JwtUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        chain.doFilter(request, response);
    }


}
