package com.yh.math.middle;

import org.junit.Test;

import java.util.Arrays;

/**
 * 移动数组
 */
public class Middle189 {

    @Test
    public void test1() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        new Solution().rotate(nums, 3);
    }

    class Solution {
        public void rotate(int[] nums, int k) {
            k=k%nums.length;
            //直接数组拷贝
            int[] newArr = new int[nums.length];
            //
            System.arraycopy(nums, 0, newArr, k, nums.length - k);
            //
            System.arraycopy(nums, nums.length - k, newArr, 0, k);
            nums=newArr;
            for (int i = 0; i < newArr.length; i++) {
                System.out.println(newArr[i]);
            }
        }
    }
}
