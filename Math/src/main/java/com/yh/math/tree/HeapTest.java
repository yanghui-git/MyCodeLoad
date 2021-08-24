package com.yh.math.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二叉堆
 */
public class HeapTest {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        List<Integer> test = arr;
        System.out.println(test);
        arr.add(222222);
        arr.add(333);
        arr.remove(0);
        System.out.println(test);

    }

    /**
     *
     */
    @Test
    public void test() {
        int[] arr = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        buildHeap(arr);
    }


    /**
     * 构建二叉堆
     *
     * @param arr
     */
    public static void buildHeap(int[] arr) {
        //从最后一个非叶子节点开始，依次做下沉操作
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            downAdjust(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆下沉操作
     *
     * @param arr         要调整的堆
     * @param parentIndex 要下沉的父节点
     * @param length      堆的有效大小
     */
    public static void downAdjust(int[] arr, int parentIndex, int length) {
        // temp 保存父节点的值 ，用于做最后的赋值
        int temp = arr[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            //如果有右孩子,且右孩子小于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && arr[childIndex + 1] < arr[childIndex]) {
                childIndex++;
            }
            //如果父节点小于任何一个孩子的值,则直接跳出
            if (temp <= arr[childIndex]) {
                break;
            }
            //无须真正交换 单向赋值即可
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        arr[parentIndex] = temp;
    }
}
