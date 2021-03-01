package com.lam.tms.common.service;

import com.github.pagehelper.PageInfo;
import com.lam.tms.common.domain.BaseEntity;
import com.lam.tms.util.QueryParameter;

import java.util.List;

/**
 * 通用 service 接口
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */

public interface BaseService<T extends BaseEntity, ID> {

    /**
     * 分页查询
     *
     * @param parameter
     * @return PageInfo<T>
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    PageInfo<T> findAllPage(QueryParameter parameter);

    /**
     * 查看所有数据，根据条件查询
     *
     * @param entity
     * @return List<T>
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    List<T> findAll(T entity);

    /**
     * 根据ID查询数据
     *
     * @param id
     * @return T
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    T findById(ID id);

    /**
     * 根据条件查询，只返回一条数据
     *
     * @param entity
     * @return T
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    T find(T entity);

    /**
     * 新增数据
     *
     * @param entity
     * @return int
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    int create(T entity);

    /**
     * 批量新增数据， 返回 新增的数量
     *
     * @param list
     * @return int
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    int batchCreate(List<T> list);

    /**
     * 修改数据，必须带 ID ，返回 被修改的数量
     *
     * @param entity
     * @return int
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    int update(T entity);

    /**
     * 根据ID删除数据，返回 删除的数量
     *
     * @param id
     * @return int
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    int deleteById(ID id);

    /**
     * 根据条件删除，返回 删除的数量
     *
     * @param entity
     * @return int
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    int delete(T entity);

    /**
     * 根据ID判断数据是否存在
     *
     * @param entity
     * @return int
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    int count(T entity);

    /**
     * 根据ID判断数据是否存在
     *
     * @param id
     * @return boolean
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    boolean existsWithPrimaryKey(ID id);

}
