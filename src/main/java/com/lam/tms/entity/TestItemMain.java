package com.lam.tms.entity;

import com.lam.tms.common.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 测试项目实体
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class TestItemMain extends BaseEntity implements Serializable {

    /**
     * 序号
     */
    private Integer id;
    /**
     * 项目标识
     */
    private String itemMark;
    /**
     * 项目名称
     */
    private String itemName;
    /**
     * 项目类别
     */
    private String itemType;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 最后更新者
     */
    private String updateBy;
    /**
     * 备注
     */
    private String comment;

}
