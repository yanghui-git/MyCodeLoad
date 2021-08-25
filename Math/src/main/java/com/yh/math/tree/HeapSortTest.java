package com.yh.math.tree;

import java.util.Arrays;

/**
 * 堆排序
 * 1 从小到大 构建最大堆
 * 2 循环删除堆顶元素,替换到二叉堆的末尾,调整堆产生新的堆顶
 */
public class HeapSortTest {

    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 3, 2, 6, 5, 7, 8, 9, 10, 0
        };
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序 升序
     *
     * @param array
     */
    public static void heapSort(int[] array) {
        // 1 将无序数组构建成最大堆
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
        System.out.println(Arrays.toString(array));
        //2  循环删除堆顶元素,移动到集合尾部，调整堆产生新的堆顶
        for (int i = array.length - 1; i > 0; i--) {
            //最后一个元素和第一个元素交换
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            // 下沉调整最大堆
            downAdjust(array, 0, i);
        }
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
            //如果有右孩子,且右孩子大于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && arr[childIndex + 1] > arr[childIndex]) {
                childIndex++;
            }
            //如果父节点大于任何一个孩子的值,则直接跳出
            if (temp >= arr[childIndex]) {
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

