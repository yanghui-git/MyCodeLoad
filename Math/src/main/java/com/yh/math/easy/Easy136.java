package com.yh.math.easy;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class Easy136 {

    @Test
    public void test() {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(new Solution().singleNumber(nums));
        nums = new int[]{2, 2, 1, 1, 6};
        System.out.println(new Solution().singleNumberTwo(nums));
        System.out.println(2%2);
        System.out.println(new Solution().singleNumberThree(nums));
    }

    class Solution {
        public int singleNumber(int[] nums) {
            int result = -1;
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                    continue;
                }
                map.put(num, 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    result = entry.getKey();
                    break;
                }
            }
            return result;
        }

        public int singleNumberTwo(int[] nums) {
            int result = -1;
            int cut = 0;
            for (int num : nums) {
                for (int num2 : nums) {
                    if (num == num2) {
                        cut += 1;
                    }
                }
                if (cut == 1) {
                    result = num;
                    break;
                }
                cut = 0;
            }
            return result;
        }


        public int singleNumberThree(int[] nums) {
            int result = 0;
            for (int n : nums) {
                result = result ^ n;
            }
            return result;
        }

    }

}
