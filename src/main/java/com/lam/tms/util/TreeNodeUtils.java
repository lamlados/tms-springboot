package com.lam.tms.util;

import com.lam.tms.common.domain.TreeNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 将List<>数据递归成，树节点的形式
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */

public class TreeNodeUtils {

    private final static int ROOT = 0;

    /**
     * 查找所有根节点
     *
     * @param allNodes
     * @return Set<TreeNode>
     */
    public static Set<TreeNode> findRoots(List<TreeNode> allNodes) {
        // 根节点
        Set<TreeNode> root = new HashSet<>();
        allNodes.forEach(node -> {
            if (node.getParentId() == ROOT) {
                root.add(node);
            }
        });
        root.forEach(node -> {
            findChildren(node, allNodes);
        });
        return root;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNode
     * @param treeNodes
     * @return TreeNode
     */
    private static TreeNode findChildren(TreeNode treeNode, List<TreeNode> treeNodes) {
        for (TreeNode it : treeNodes) {
            if (treeNode.getId() == it.getParentId()) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new HashSet<>());
                }
                treeNode.getChildren().add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }

}
