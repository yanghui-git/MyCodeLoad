package com.yh.math.easy;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 * 移动0
 */
public class Easy283 {

    @Test
    public void testOne() {
        int[] testArr = new int[]{0, 1, 0, 3, 12};
     //   new Solution().moveZeroes(testArr);
        new Solution().moveZeroesTwo(testArr);
        System.out.println(testArr.toString());
    }


    class Solution {

        public void moveZeroes(int[] nums) {
            int t = 0;
            //塞到新数组
            for (int n : nums) {
                if (n != 0) {
                    nums[t] = n;
                    t++;
                }
            }
            //填充 0
            while (t < nums.length) {
                nums[t] = 0;
                t++;
            }
        }


        public void moveZeroesTwo(int[] nums) {
            int n = nums.length, left = 0, right = 0;
            while (right < n) {
                if (nums[right] != 0) {
                    swap(nums, left, right);
                    left++;
                }
                right++;
            }
        }

        public void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

    }

}
