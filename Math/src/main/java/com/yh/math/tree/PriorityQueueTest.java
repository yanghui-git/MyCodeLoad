package com.yh.math.tree;

import org.junit.Test;

import java.util.Arrays;

/**
 * 优先队列  （涉及二叉堆的上浮 下浮  元素删除）
 */
public class PriorityQueueTest {


    class PriorityQueue {
        private int[] arr;
        private int size;

        public PriorityQueue() {
            arr = new int[32];
        }

        /**
         * 入队列 添加元素
         *
         * @param key
         */
        public void enQueue(int key) {
            if (size >= arr.length) {
                resize();
            }
            arr[size++] = key;
            //上浮调整
            upAdjust();
        }

        /**
         * 出队列
         *
         * @return
         */
        public int deQueue() throws Exception {
            if (size <= 0) {
                throw new Exception(" empty ");
            }
            //获取堆顶元素
            int head = arr[0];
            //让最后的元素移动到堆顶
            arr[0] = arr[--size];
            // 下浮调整
            downAdjust();
            return head;
        }

        /**
         * 上浮调整
         */
        private void upAdjust() {
            int childIndex = size - 1;
            int parentIndex = childIndex / 2;
            // temp 用于保存插入的叶子节点值 ,用于最后的赋值
            int temp = arr[childIndex];
            while (childIndex > 0 && temp > arr[parentIndex]) {
                arr[childIndex] = arr[parentIndex];
                childIndex = parentIndex;
                parentIndex = parentIndex / 2;
            }
            arr[childIndex] = temp;
        }

        /**
         * 扩容处理
         */
        public void resize() {
            int newSize = size * 2;
            this.arr = Arrays.copyOf(this.arr, newSize);
        }

        /**
         * 下沉调整
         */
        public void downAdjust() {
            int parentIndex = 0;
            // temp 保存父节点的值,用于最后的赋值
            int temp = arr[parentIndex];
            int childIndex = 1;
            while (childIndex < size) {
                //如果有右孩子 且右孩子值大于左孩子的值 则定位到右孩子
                if (childIndex + 1 < size && arr[childIndex + 1] > arr[childIndex]) {
                    childIndex++;
                }
                //如果父节点大于等于 任何一个孩子的值 直接跳过
                if (temp > arr[childIndex]) {
                    break;
                }
                //
                arr[parentIndex] = arr[childIndex];
                parentIndex = childIndex;
                childIndex = 2 * parentIndex + 1;
            }
            arr[parentIndex] = temp;
        }

    }


    @Test
    public void test() throws Exception {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(6);
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(20);
        priorityQueue.enQueue(30);
        priorityQueue.enQueue(4);
        priorityQueue.enQueue(2);
        //出队列验证
        while (priorityQueue.size > 0) {
            System.out.println(priorityQueue.deQueue());
        }
    }

}
