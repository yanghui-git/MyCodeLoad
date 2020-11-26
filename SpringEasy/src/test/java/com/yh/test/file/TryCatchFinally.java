package com.yh.test.file;

import org.junit.Test;

public class TryCatchFinally {


    public static int getFinally() {
        int a = 0;
        try {
            a = 1 / 0;
        } catch (Exception e) {
            return a + 1;
        } finally {
            return a - 1;
        }
    }

    public static int getFinally2() {
        int a = 0;
        try {
            a = 1 / 0;
        } catch (Exception e) {
            return 6;
        } finally {
            return 3;
        }
    }

    public static int getFinally3() {
        int a = 100;
        try {
            a=1/0;
            return a;
        } catch (Exception e) {
            a=200;
            return a+5;
        } finally {
            return ++a;
        }
    }

    @Test
    public void test() {
        System.out.println(getFinally());
        System.out.println(getFinally2());
        System.out.println(getFinally3());
    }
}
