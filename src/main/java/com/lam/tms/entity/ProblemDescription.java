package com.lam.tms.entity;

import com.lam.tms.common.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author lamlados
 * @date 2021/2/28 22:43
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class ProblemDescription extends BaseEntity implements Serializable {
    /**序号*/
    private Integer id;
    /**项目标识*/
    private String itemMark;
    /**问题标识*/
    private String problemMark;
    /**用例测试号*/
    private String caseNumber;
    /**问题类型*/
    private String problemType;
    /**问题级别*/
    private String problemLevel;
    /**问题描述*/
    private String problemDescription;
    /**创建者*/
    private String createBy;
    /**最后更新者*/
    private String updateBy;
    /**备注*/
    private String comment;
}
