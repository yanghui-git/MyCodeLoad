package com.yh.math.test;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/binary-search/
 * 简单二分查找
 */
public class EasyTest {

    @Test
    public void test() {
        int[] arr = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(new Solution().search(arr, 12));
        System.out.println(new Solution().search(arr, 10));
        System.out.println(new Solution().search(arr, 5));
    }

    class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = (nums.length - 1);
            while (left <= right) {
                int mid = (right + left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                } else if (target > nums[mid]) {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }
}
