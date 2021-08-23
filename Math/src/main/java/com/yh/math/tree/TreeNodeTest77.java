package com.yh.math.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 二叉树 前中后 序遍历
 */
public class TreeNodeTest77 {

    /**
     * 二叉树节点
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class TreeNode {
        int data;
        TreeNode leftNode;
        TreeNode rightNode;
    }

    /**
     * 构建二叉树
     *
     * @param inputList
     * @return
     */
    public static TreeNode createTreeNode(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data, null, null);
            node.leftNode = createTreeNode(inputList);
            node.rightNode = createTreeNode(inputList);
        }
        return node;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(
                new Integer[]{
                        3, 2, 9, null, null, 10, null, null, 8, null, 4
                }
        ));
        TreeNode node = createTreeNode(list);
        // System.out.println(node);
        preOrderTravel(node);
        System.out.println("---------");
        postOrderTravel(node);
        System.out.println("-----");
        preOrderTravel2(node);
        System.out.println("-----");
        levelOrderTravel(node);
    }

    /**
     * 前序遍历
     *
     * @param node
     */
    public static void preOrderTravel(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTravel(node.leftNode);
        preOrderTravel(node.rightNode);
    }

    /**
     * 后续遍历
     *
     * @param node
     */
    public static void postOrderTravel(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTravel(node.leftNode);
        postOrderTravel(node.rightNode);
        System.out.println(node.data);
    }

    /**
     * 用栈实现非递归前序遍历'--深度优先
     */
    public static void preOrderTravel2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        //迭代访问 节点的左孩子 并入栈
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftNode;
            }
            //如果节点没有左孩子 则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightNode;
            }
        }

    }

    /**
     * 二叉树层序遍历  广度优先 非递归
     *
     * @param root
     */
    public static void levelOrderTravel(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.data);
            //将左右节点放入队列
            if (node.leftNode != null) {
                queue.offer(node.leftNode);
            }
            if (node.rightNode != null) {
                queue.offer(node.rightNode);
            }
        }
    }
}
