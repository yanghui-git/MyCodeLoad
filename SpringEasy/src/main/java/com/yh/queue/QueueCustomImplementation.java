package com.yh.queue;

import lombok.Data;
import org.junit.Test;

import java.util.*;

/**
 * JAVA 数据结构队列  自定义实现
 */
public class QueueCustomImplementation {

    /**
     * 数组实现队列
     * https://blog.csdn.net/NuanShuTT/article/details/108573687?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-2.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-2.control
     */
    @Data
    class ArrayQueue {
        //队列大小
        private int size = 3;

        private Integer[] array = new Integer[size];

        //计数 记录当前元素个数
        int i = 0;

        //构造函数
        public ArrayQueue(int size) {
            this.size = size;
            this.array = new Integer[size];
        }


        //入队列
        public void add(Integer node) {
            //判断是否超出限制
            if (i < size) {
                array[i] = node;
                i++;
            } else {
                throw new RuntimeException("已超出设定限制，不能增加元素");
            }
        }

        //出队列
        public Integer poll() {
            //说明最后一位了 没有元素了
            if (i <= 0) {
                return null;
            }
            int temp = array[0];
            //数量-1
            i--;
            //数组前移
            for (int index = 0; index < i; index++) {
                array[index] = array[index + 1];
            }
            //最后一位null
            array[i] = null;
            return temp;
        }

    }

    @Test
    public void arrayTest() {
        ArrayQueue queue = new ArrayQueue(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        /*boolean test = true;
        while (test) {
            Integer a = queue.poll();
            System.out.println(a);
            test = a == null ? false : true;
        }*/
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        queue.add(6);
        queue.add(7);
        System.out.println(queue);
    }


    /**
     * 两个栈实现队列
     * https://blog.csdn.net/dangzhangjing97/article/details/81477192?utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control
     */
    public class TwoStackQueue {
        Stack<Integer> stackA = new Stack<Integer>();
        Stack<Integer> stackB = new Stack<Integer>();

        /**
         * 入栈
         */
        public void push(Integer node) {
            // A接收
            stackA.push(node);
        }

        /**
         * 出栈
         */
        public Integer pop() {
            if (stackA.isEmpty() && stackB.isEmpty()) {
                return null;
            }
            if (!stackB.isEmpty()) {
                return stackB.pop();
            }
            //B中元素为空时，则把A中所有元素推入B中
            while (stackA.size() > 0) {
                stackB.push(stackA.pop());
            }
            return stackB.pop();
        }

    }

    @Test
    public void stackTest2() {
        TwoStackQueue stackQueue = new TwoStackQueue();
        stackQueue.push(1);
        stackQueue.push(2);
        stackQueue.push(3);
        stackQueue.push(4);
        System.out.println(stackQueue.pop());//1
        System.out.println(stackQueue.pop());//2
        System.out.println(stackQueue.pop());//3
        stackQueue.push(5);
        stackQueue.push(6);
        System.out.println(stackQueue.pop());//4
        System.out.println(stackQueue.pop());//5

    }


    @Test
    public void stackTest() {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(1);
        integerStack.push(2);
        //获取栈顶 不移除
        //  System.out.println(integerStack.peek());
        //    System.out.println(integerStack.peek());

        //获取移除
        System.out.println(integerStack.pop());
        //   System.out.println(integerStack.pop());
        integerStack.push(3);
        System.out.println(integerStack.pop());
        System.out.println(integerStack.pop());
        System.out.println(integerStack.isEmpty());
    }


    /**
     * 两个队列实现栈
     * https://blog.csdn.net/zangdaiyang1991/article/details/88626639?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-4.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-4.control
     * 1、 一个队列加入元素，弹出元素时，需要把队列中的 元素放到另外一个队列中，删除最后一个元素
     * 2、 两个队列始终保持只有一个队列是有数据的
     */
    public class TwoQueueStack {

        Queue queueA = new LinkedList();
        Queue queueB = new LinkedList();

        /**
         * 入栈
         */
        public void push(Integer node) {
            //初始化 都是空的情况
            if (queueA.isEmpty() && queueB.isEmpty()) {
                queueA.add(node);
            } else if (queueA.isEmpty() && !queueB.isEmpty()) {
                queueB.add(node);
            } else if (!queueA.isEmpty() && queueB.isEmpty()) {
                queueA.add(node);
            } else if (!queueA.isEmpty() && !queueB.isEmpty()) {
                throw new RuntimeException("error data ");
            }
        }

        /**
         * 出栈
         */
        public Object pop() {
            if (queueA.isEmpty() && queueB.isEmpty()) {
                return null;
            } else if (!queueA.isEmpty() && !queueB.isEmpty()) {
                throw new RuntimeException("error data ");
            } else if (!queueA.isEmpty() && queueB.isEmpty()) {
                while (queueA.size() > 1) {
                    queueB.add(queueA.poll());
                }
                return queueA.poll();
            } else if (queueA.isEmpty() && !queueB.isEmpty()) {
                while (queueB.size() > 1) {
                    queueA.add(queueB.poll());
                }
                return queueB.poll();
            }
            return null;
        }

    }

    @Test
    public void twoQueueStack() {
        TwoQueueStack twoQueueStack = new TwoQueueStack();
        twoQueueStack.push(1);
        twoQueueStack.push(2);
        twoQueueStack.push(3);
        twoQueueStack.push(4);
        System.out.println(twoQueueStack.pop());//4
        System.out.println(twoQueueStack.pop());//3
        twoQueueStack.push(5);
        twoQueueStack.push(6);
        System.out.println(twoQueueStack.pop());//6
        System.out.println(twoQueueStack.pop());//5
        System.out.println(twoQueueStack.pop());//2
    }


}
