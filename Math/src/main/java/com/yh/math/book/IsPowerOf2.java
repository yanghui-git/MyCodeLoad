package com.yh.math.book;


/**
 * 如何判断一个数 是否是2的整数次幂  &运算
 */
public class IsPowerOf2 {

    public static void main(String[] args) {
        System.out.println(isPowerOf2(0));
        System.out.println(isPowerOf2(16));
        System.out.println(isPowerOf2(19));
        System.out.println(3 << 3);

        System.out.println(isPowerOf2(16));
        System.out.println(isPowerOf2(100));
        System.out.println(isPowerOf2(132));
        System.out.println(isPowerOf2(128));
    }

    /**
     * 暴力法
     */
    public static boolean isPowerOf2(int num) {
        if (num == 1) {
            return true;
        }
        int tmp = 1;
        while (tmp <= num) {
            if (tmp == num) {
                return true;
            }
            tmp = tmp * 2;
        }
        return false;
    }

    /**
     * 按位& https://www.cnblogs.com/leijee/p/7494000.html
     * 8 --1000
     * 7   0111     0
     * <p>
     * 16 10000
     * 15 01111     0
     * <p>
     * 100 1100100
     * 99  1100011   1100000
     */
    public static boolean isPowerO2(int num) {
        return (num & num - 1) == 0;
    }


}
