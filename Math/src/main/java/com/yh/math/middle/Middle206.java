package com.yh.math.middle;

import org.junit.Test;


import java.util.Stack;

/**
 * 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class Middle206 {

    @Test
    public void test() {
        ListNode node = new ListNode(1, null);
        node.next = new ListNode(2, null);
        node.next.next = new ListNode(3, null);
        node.next.next.next = new ListNode(4, null);
        System.out.println(new Solution().reverseList(node));
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

    class Solution {
        public ListNode reverseList(ListNode head) {
            Stack<ListNode> stack = new Stack<>();
            //临时节点
            ListNode start = new ListNode(0, new ListNode());
            while (head!= null) {
                stack.push(head);
                head = head.next;
            }
            //
            ListNode tmp = start;
            while (!stack.isEmpty()) {
                tmp.next = stack.pop();
                tmp = tmp.next;
            }
            tmp.next=null;
            return start.next;
        }
    }
}
