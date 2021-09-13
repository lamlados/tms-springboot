package com.lam.tms.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author lamlados
 * @date 2021/3/24 12:48
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class DictQueryItem {

    /**
     * 字典类型
     */
    private String dictType;
    /**
     * 字典内容
     */
    private String dictContent;
    /**
     * 字典标识
     */
    private String dictMark;

}
