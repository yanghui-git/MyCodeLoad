package com.yh.math.middle;

public class Middle162 {

    class Solution {
        public int findPeakElement(int[] nums) {
            if(nums.length<=1){
                return -1;
            }
            for(int i=1;i<nums.length-1;i++){
                if(nums[i]>nums[i-1]&&nums[i]>nums[i+1]){
                    return i;
                }
            }
            return -1;
        }
    }
}
