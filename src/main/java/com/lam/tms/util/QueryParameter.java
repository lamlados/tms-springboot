package com.lam.tms.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * 通用查询参数
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */

@Getter
@Setter
@ToString
public class QueryParameter implements java.io.Serializable {

    /**
     * @description: 当前第几页
     * @date: 2021/2/20 15:26
     */
    private int pageNum = 1;

    /**
     * @description: 每页多少条数据
     * @date: 2021/2/20 15:26
     */
    private int pageSize = 10;

    /**
     * @description: 搜索，关键字
     * @date: 2021/2/20 15:26
     */
    private String keywords;

}
