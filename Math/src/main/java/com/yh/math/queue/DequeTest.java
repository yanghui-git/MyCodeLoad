package com.yh.math.queue;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class DequeTest {

    @Test
    public void testOne(){
        Deque deque=new LinkedList();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        System.out.println(deque.poll());
        System.out.println(deque.poll());

    }

}
