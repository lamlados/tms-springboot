package com.lam.tms.common.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Set;

/**
 * @author lamlados
 * @date 2021/2/20 15:26
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TreeNode implements java.io.Serializable {

    /**
     * 获取 当前节点 ID
     *
     * @return int
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    private int id;

    /**
     * 当前节点标题
     *
     * @return int
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    private String title;

    /**
     * 上级节点 ID
     *
     * @return int
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    private int parentId;

    /**
     * 源属性
     *
     * @return int
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    private Object source;

    /**
     * 获取 所有子节点
     * @JsonInclude(JsonInclude.Include.NON_NULL)
     * @return int
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<TreeNode> children;

}
