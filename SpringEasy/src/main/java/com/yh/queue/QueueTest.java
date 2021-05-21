package com.yh.queue;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * JAVA 队列学习  FIFO 先进先出
 * 队列是一种特殊的线性表，它只允许在表的前端进行删除操作，而在表的后端进行插入操作。
 */
public class QueueTest {

    @Test
    public void test1() {
        Queue<String> queue = new LinkedList<>();
        //添加元素
        queue.add("1");
        queue.add("2");
        queue.offer("3");
        queue.stream().forEach(q -> System.out.println(q));
        System.out.println();
        //返回队列第一个元素，并且删除
        System.out.println(queue.poll() + "........");
        queue.stream().forEach(q -> System.out.println(q));
        System.out.println();
        //返回队列第一个元素，不删除
        System.out.println(queue.peek()+ "........");
        queue.stream().forEach(q -> System.out.println(q));
        System.out.println();

        //返回队列第一个元素，不删除
        System.out.println(queue.element()+ "........");
        queue.stream().forEach(q -> System.out.println(q));
    }

}
