package com.yh.math.easy;

import org.junit.Test;

/**
 * 滑动窗口
 * Input: [-3, 3, 1, -3, 2, 4, 7], n=3
 * Output: 13
 */
public class SlideEasy {

    int[] arr = new int[]{-3, 3, 1, -3, 2, 4, 7};
    int k = 3;

    /**
     * 暴力解法
     *
     * @param arr
     * @param k
     * @return
     */
    public int getMax(int arr[], int k) {
        if (arr == null || arr.length == 0 || k < 0 || k >= arr.length) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            int temp = arr[i];
            for (int j = 1; j < k; j++) {
                temp = temp + arr[i + j];
            }
            System.out.println(temp);
            max = Math.max(max, temp);
        }
        return max;

    }

    /**
     * 滑动窗口
     *
     * @param arr
     * @param k   int[] arr = new int[]{-3, 3, 1, -3, 2, 4, 7};
     *            int k = 3;
     * @return
     */
    public int getMaxTwo(int arr[], int k) {
        if (arr == null || arr.length == 0 || k < 0 || k >= arr.length) {
            return 0;
        }
        //记录第一个窗口的值
        int first = 0;
        for (int i = 0; i < k; i++) {
            first += arr[i];
        }
        System.out.println("第一个窗口值" + first);
        //最大值
        int max = first;

        //后续窗口值计算 = 前窗口值+新值-旧值
        int temp = first;
        for (int i = 0; i < arr.length - k; i++) {
            //后续窗口值
            temp += +arr[k + i] - arr[i];
            System.out.println(temp);
            max = Math.max(max, temp);
        }
        return max;
    }


    @Test
    public void test() {
        System.out.println(getMax(arr, k));
        System.out.println("-----");
        System.out.println(getMaxTwo(arr, k));
    }
}
