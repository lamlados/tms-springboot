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
    private String dictType;
    private String dictContent;
    private String dictMark;
}
