package com.lam.tms.entity;

import com.lam.tms.common.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 测试用例设计实体
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class TestCaseDesign extends BaseEntity implements Serializable {
	/**序号*/
    private Integer id;
	/**项目标识*/
    private String itemMark;
	/**项目分类标识*/
    private String classificationMark;
	/**用例标识*/
    private String caseMark;
	/**测试追踪*/
    private String testTrack;
	/**测试方法*/
    private String testMethod;
	/**测试说明*/
    private String testDescription;
	/**前提和约束*/
    private String premiseConstraint;
	/**终止条件*/
    private String endCondition;
	/**输入及操作说明*/
    private String operatingDescription;
	/**期望测试结果*/
    private String expectedResult;
	/**评估准则*/
    private String evaluationCriteria;
	/**创建者*/
    private String createBy;
	/**最后更新者*/
    private String updateBy;
	/**备注*/
    private String comment;
}
