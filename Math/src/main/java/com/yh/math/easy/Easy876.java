package com.yh.math.easy;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 * 求链表的中心节点
 */
public class Easy876 {

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(new Solution().middleNode(node).val);
        System.out.println(new Solution().middleNodeTwo(node).val);
        System.out.println(new Solution().middleNodeThree(node).val);

    }

    class Solution {

        /**
         * 纯数组
         *
         * @param head
         * @return
         */
        public ListNode middleNode(ListNode head) {
            ListNode[] ListNode = new ListNode[100];
            int t = 0;
            while (head != null) {
                ListNode[t++] = head;
                head = head.next;
            }
            return ListNode[t / 2];
        }

        /**
         * 单指针
         *
         * @param head
         * @return
         */
        public ListNode middleNodeTwo(ListNode head) {
            //判断有多少个节点
            ListNode oldNode = head;
            int count = 0;
            while (oldNode != null) {
                count++;
                oldNode = oldNode.next;
            }
            //直接取出中间节点
            int tmp = 0;
            while (tmp < count / 2) {
                tmp++;
                head = head.next;
            }
            return head;
        }

        /**
         * 快慢指针
         *
         * @param head
         * @return
         */
        public ListNode middleNodeThree(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
