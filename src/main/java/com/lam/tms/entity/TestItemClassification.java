package com.lam.tms.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author lamlados
 * @date 2021/3/28 12:43
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class TestItemClassification {
    /**序号*/
    private Integer id;
    /**项目标识*/
    private String itemMark;
    /**项目名称*/
    private String itemName;
    /**项目大分类*/
    private String classificationBig;
    /**项目大分类标识*/
    private String bigMark;
    /**项目中分类*/
    private String classificationMedium;
    /**项目中分类标识*/
    private String mediumMark;
    /**项目小分类*/
    private String classificationSmall;
    /**项目小分类标识*/
    private String smallMark;
    /**创建者*/
    private String createBy;
    /**最后更新者*/
    private String updateBy;
    /**备注*/
    private String comment;
}
