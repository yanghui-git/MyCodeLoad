package com.yh.math.queue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * 手写队列
 */
public class LinkedListTest {

    @Test
    public void test() {
        Queue queue = new MyQueue();
        queue.add(1);
        queue.add(2);
        queue.add(10);
      //  System.out.println(queue.toString());
        System.out.println(queue.peek());
    }


    /**
     * 手写queue
     */
    class MyQueue implements Queue {

        /**
         * 底层Node
         *
         * @param <E>
         */
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        class Node<E> {
            E item;
            Node<E> pre;
            Node<E> next;
        }

        //头部节点
        private Node first = null;
        //尾部节点
        private Node last = null;
        //
        private int size = 0;

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public Object[] toArray(Object[] a) {
            return new Object[0];
        }

        @Override
        public boolean add(Object o) {
            //临时节点
            Node l = last;
            //新节点
            Node newNode = new Node<>(o, last, null);
            //更新最后节点
            last = newNode;
            //判断是否是第一个元素插入
            if (l == null) {
                first = newNode;
            } else {
                //更改指针
                l.next = newNode;
            }
            size++;
            return true;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean addAll(Collection c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public boolean retainAll(Collection c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection c) {
            return false;
        }

        @Override
        public boolean containsAll(Collection c) {
            return false;
        }

        @Override
        public boolean offer(Object o) {
            return false;
        }

        @Override
        public Object remove() {
            return null;
        }

        @Override
        public Object poll() {
            return null;
        }

        @Override
        public Object element() {
            return null;
        }

        @Override
        public Object peek() {
            return first.item;
        }
    }
}
