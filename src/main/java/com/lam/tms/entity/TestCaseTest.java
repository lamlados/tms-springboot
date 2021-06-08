package com.lam.tms.entity;

import com.lam.tms.common.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author lamlados
 * @date 2021/3/1 23:15
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class TestCaseTest extends BaseEntity implements Serializable {
    /**序号*/
    private Integer id;
    /**项目标识*/
    private String itemMark;
    /**用例标识*/
    private String caseMark;
    /**测试版本*/
    private String testVersion;
    /**实际结果*/
    private String actualResult;
    /**执行结果*/
    private String executionResult;
    /**测试人员*/
    private String testBy;
    /**监督人员*/
    private String supervisedBy;
    /**执行日期*/
    private String executionDate;
    /**创建者*/
    private String createBy;
    /**最后更新者*/
    private String updateBy;
    /**备注*/
    private String comment;
}
