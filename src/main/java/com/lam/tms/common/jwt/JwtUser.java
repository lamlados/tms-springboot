package com.lam.tms.common.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Spring Security 认证 UserDetails 实现类
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */

@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtUser implements UserDetails {

    /**
     * 用户唯一ID
     *
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    private Integer id;

    /**
     * 用户登录时，使用的用户名
     *
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    private String username;

    /**
     * 用户登录时，使用的密码
     *
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    private String password;

    /**
     * 用户状态， [ 0.禁用 1.正常 2.被删除 ]
     *
     * @author lamlados
     * @date 2021/2/20 15:26
     */
//    private Integer status;

    private Collection<? extends GrantedAuthority> authorities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public Integer getStatus() {
//        return status;
//    }
//
//    public void setStatus(Integer status) {
//        this.status = status;
//    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
//        return status == StatusConstant.NORMAL;
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

}
