package com.yh.math.test;

import org.junit.Test;

/**
 * 动态规划
 * https://zhuanlan.zhihu.com/p/91582909
 */
public class DynamicProgramming {

    /**
     * 1 青蛙 跳台阶 跳1阶 / 跳2阶
     */
    @Test
    public void testOne() {
        System.out.println(compute(5));
    }

    public int compute(int n) {
        if (n <= 2) {
            return n;
        }
        //创建数组保存历史数据
        int[] dp = new int[n + 1];
        //初始化数据
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        //计算数据
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        //返回结果
        return dp[n];
    }

    /**
     * 机器人问题 二维数组
     */
    @Test
    public void testTwo() {
        System.out.println(compute(50000, 100));
    }

    public int compute(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        //初始化
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            //一直往右
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            //一直向下
            dp[0][j] = 1;
        }
        //推导dp[m-1][n-1]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 机器人问题拓展 二维数组
     */
    @Test
    public void testThree() {
        int[][] arr = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(compute2(arr));
    }

    public int compute2(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        //初始化
        dp[0][0] = arr[0][0];
        //初始化横列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }
        //初始化纵列
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + arr[0][j];
        }
        //组建关系式
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }


}