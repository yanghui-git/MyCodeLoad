package com.yh.math.tree;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 二叉查找树
 * 如果左子树 不为空 则左子树所有节点的值 小于跟节点的值
 * 如果右子树 不为空 则右子树所有节点的值 大于跟节点的值
 * 左，右子树 也都是二叉查找树
 * 6
 * 3          8
 * 2   4       7    9
 * 1
 *
 *
 *
 * 缺陷
 *
 *        9
 *       8  12
 *      7
 *     6
 *    5
 *   4
 *  3
 * 2
 *1
 * 变瘸 查找时间复杂度变为O(n)
 */
public class TwoSearchTree {

    static Node root = null;

    public static void main(String[] args) {
        insert(6);
        insert(8);
        insert(3);
        insert(2);
        insert(4);
        insert(7);
        insert(9);
        insert(1);
        search(10);
        search(1);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Node {
        Integer date;
        Node left;
        Node right;
    }

    /**
     * 插入节点
     */
    public static boolean insert(int data) {
        Node node = new Node(data, null, null);
        if (root == null) {
            root = node;
            return true;
        }
        Node target = root;
        while (target != null) {
            if (data == target.date) {
                System.out.println("二叉树中已存在重复节点 : " + data);
                return false;
            } else if (data > target.date) {
                if (target.right == null) {
                    target.right = node;
                    return true;
                }
                target = target.right;
            } else {
                if (target.left == null) {
                    target.left = node;
                    return true;
                }
                target = target.left;
            }
        }
        return true;
    }


    /**
     * 查找节点
     */
    public static Node search(int data) {
        Node target = root;
        while (target != null && target.date != data) {
            if (data > target.date) {
                target = target.right;
            } else {
                target = target.left;
            }
        }
        if (target == null) {
            System.out.println("未找到节点 " + data);
        } else {
            System.out.println("已找到节点  " + target.toString());
        }
        return target;
    }

}
