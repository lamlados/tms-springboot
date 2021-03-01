package com.lam.tms.common.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * MyBatis 通用 Mapper 接口
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */

public interface BaseMapper<T, ID> extends Mapper<T>, MySqlMapper<T> {

}
