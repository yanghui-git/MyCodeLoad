package com.yh.math.queue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.*;

/**
 * 手写双端队列
 * https://blog.csdn.net/l540675759/article/details/62893335
 *
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


    @Test
    public void testTwo() {
        Deque deque = new MyQueue();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        System.out.println(deque.peek());
    }


    /**
     * 手写queue
     */
    class MyQueue implements Deque {

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

        /**
         * 双端队列 作栈处理
         */
        @Override
        public void push(Object o) {
            Node l = first;
            Node newNode = new Node(o, null, first);
            //更新前置节点
            first = newNode;
            if (l == null) {
                last = newNode;
            } else {
                l.pre = newNode;
            }
        }

        @Override
        public Object pop() {
            return null;
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
        public Iterator descendingIterator() {
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
        public void addFirst(Object o) {

        }

        @Override
        public void addLast(Object o) {

        }

        @Override
        public boolean offerFirst(Object o) {
            return false;
        }

        @Override
        public boolean offerLast(Object o) {
            return false;
        }

        @Override
        public Object removeFirst() {
            return null;
        }

        @Override
        public Object removeLast() {
            return null;
        }

        @Override
        public Object pollFirst() {
            return null;
        }

        @Override
        public Object pollLast() {
            return null;
        }

        @Override
        public Object getFirst() {
            return null;
        }

        @Override
        public Object getLast() {
            return null;
        }

        @Override
        public Object peekFirst() {
            return null;
        }

        @Override
        public Object peekLast() {
            return null;
        }

        @Override
        public boolean removeFirstOccurrence(Object o) {
            return false;
        }

        @Override
        public boolean removeLastOccurrence(Object o) {
            return false;
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
