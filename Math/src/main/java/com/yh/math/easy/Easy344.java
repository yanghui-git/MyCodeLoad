package com.yh.math.easy;

import org.junit.Test;

public class Easy344 {

    @Test
    public void test() {
        char[] chars = "hello".toCharArray();
        reverseString(chars);
        System.out.println(chars);
        reverseString2(chars);
        System.out.println(chars);
    }

    ;


    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
    }

    public void reverseString2(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[right];
            s[right] = s[left];
            s[left] = tmp;
            left++;
            right--;
        }
    }
}
