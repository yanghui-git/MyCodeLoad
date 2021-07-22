package com.yh.math.easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


/**
 * 反转数组
 */
public class ArrayEasy {

    // 1 利用栈
    @Test
    public void test1() {
        String[] arr = new String[]{"1", "2", "3", "4", "5"};
        Stack<String> stack = new Stack();
        Arrays.asList(arr).stream().forEach(ar -> stack.push(ar));
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    //2 暴力copy
    @Test
    public void test2() {
        String[] arr = new String[]{"1", "2", "3", "4", "5"};
        String[] newArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[arr.length - i - 1] = arr[i];
        }
        System.out.println(newArr.toString());
    }

    //3 工具类
    @Test
    public void test3() {
        String[] arr = new String[]{"1", "2", "3", "4", "5"};
        List list = Arrays.asList(arr);
        Collections.reverse(list);
        System.out.println(list);
    }

    //4 指针元素互换
    @Test
    public void test4() {
        String[] arr = new String[]{"1", "2", "3", "4", "5"};
        //元素交换
        int right = arr.length - 1;
        int left = 0;
        while (left < right) {
            String tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
        Arrays.asList(arr).stream().forEach(a -> System.out.println(a));
    }
}
