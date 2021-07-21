package com.yh.math.queue;

import org.junit.Test;

import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;

/**
 * 栈解读
 */
public class StackTest {

    @Test
    public void test() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
    }

    @Test
    public void testOne() {
        Vector vector = new Vector();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        System.out.println(vector.capacity());
      //  System.out.println(vector.firstElement());
        System.out.println(vector.elementAt(2));
        Iterator iterator = vector.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
