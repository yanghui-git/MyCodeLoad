package com.yh.math.easy;

import org.junit.Test;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈
 *
 */
public class Easy155 {

    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(10);
        minStack.push(6);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.a);
        System.out.println(minStack.b);
        System.out.println(minStack.getMin());
    }

    class MinStack {

        Stack a;

        /**
         * 存储最小
         */
        Stack b;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            a = new Stack();
            b = new Stack();
        }

        public void push(int val) {
            a.push(val);
            if (b.isEmpty() || val <= (int) b.peek()) {
                b.push(val);
            }
        }

        public void pop() {
            if (a.pop().equals(b.peek())) {
                b.pop();
            }
        }

        public int top() {
            return (int) a.peek();
        }

        public int getMin() {
            return (int) b.peek();
        }
    }

}
