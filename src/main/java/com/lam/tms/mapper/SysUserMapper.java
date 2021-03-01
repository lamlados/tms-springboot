package com.lam.tms.mapper;

import com.lam.tms.common.mapper.BaseMapper;
import com.lam.tms.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * 用户Mapper
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */

@Mapper
@Repository
public interface SysUserMapper extends BaseMapper<SysUser, Integer> {

    /**
     * 根据 用户名，和 昵称，模糊匹配
     */
    Set<SysUser> selectByKeywords(String keywords);
    SysUser findByUsername(String username);

}
