package com.yh.math.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeTest {

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class TreeNode {
        private Object data;
        private TreeNode left;
        private TreeNode right;
    }

    /**
     * 手撕二叉树构建+ 广度优先遍历
     */
    @Test
    public void test() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(
                new Integer[]{
                        3, 2, 9, null, null, 10, null, null, 8, null, 4
                }
        ));
        TreeNode node = createTreeNode(list);
        levelOrder(node);
    }

    public TreeNode createTreeNode(LinkedList linkedList) {
        TreeNode treeNode = null;
        if (linkedList == null || linkedList.isEmpty()) {
            return treeNode;
        }
        Object date = linkedList.removeFirst();
        if (date != null) {
            treeNode = new TreeNode(date, null, null);
            //构建左右节点
            treeNode.left = createTreeNode(linkedList);
            treeNode.right = createTreeNode(linkedList);
        }
        return treeNode;
    }


    /**
     * 广度优先
     */
    public void levelOrder(TreeNode node) {
        //用一个队列存储
        Queue queue = new LinkedList();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode no = (TreeNode) queue.poll();
            System.out.println(no.data);
            if (no.left != null && no.left.data != null) {
                queue.offer(no.left);
            }
            if (no.right != null && no.right.data != null) {
                queue.offer(no.right);
            }
        }
    }
}
