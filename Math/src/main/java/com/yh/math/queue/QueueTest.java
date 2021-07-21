package com.yh.math.queue;

import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

    @Test
    public void testOne(){
        Queue queue= new LinkedList();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
       // System.out.println(queue.remove());
        System.out.println(queue.peek());
      //  System.out.println(queue.element());
    }
}
