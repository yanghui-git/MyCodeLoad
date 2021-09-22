package com.yh.math.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 斐波那且数列及其优化
 * https://zhuanlan.zhihu.com/p/108269159
 * <p>
 * 1 1 2 3 5 8 13
 */
public class FBNQ {


    public static void main(String[] args) {

        System.out.println(testOne(6));
        System.out.println(testTwo(6));
        System.out.println(testThree(6));
        System.out.println(testFour(6));

    }

    /**
     * 纯递归
     */
    public static int testOne(int n) {
        if (n < 3) {
            return 1;
        }
        return testOne(n - 1) + testOne(n - 2);
    }

    /**
     * 非递归
     */
    public static int testTwo(int n) {
        if (n < 3) {
            return 1;
        }
        Map map = new HashMap<Object, Integer>();
        map.put(1, 1);
        map.put(2, 1);
        for (int i = 3; i <= n; i++) {
            map.put(i, (Integer) map.get(i - 1) + (Integer) map.get(i - 2));
        }
        return (Integer) map.get(n);
    }

    /**
     * 非递归
     */
    public static int testThree(int n) {
        if (n < 3) {
            return 1;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        for (int i = 2; i < n; i++) {
            list.add((Integer) list.get(i - 1) + (Integer) list.get(i - 2));
        }
        return list.get(n - 1);
    }

    /**
     * 非递归 --指针移动
     */
    public static int testFour(int n) {
        if (n < 3) {
            return 1;
        }

        int left = 1;
        int right = 1;
        for (int i = 3; i <= n; i++) {
            int temp = right + left;
            left = right;
            right = temp;
        }
        return right;
    }
}
