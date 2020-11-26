package com.yanghui.testone;

import org.junit.Test;

public class TryExceptionTest {

    public static int getData(int a, int b) {
        int result = 0;
        try {
            return a / b;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static void main(String[] args) {
        int c = 0;
        try {
            c = getData(2, 0);
            // c=2;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(c);

    }

    @Test
    public void trtTest() {
        int a = 1;
        try {
            a = 2;
            int c = a / 0;
        } catch (Exception e) {
            // e.printStackTrace();
        }

        System.out.println(a);  //2
    }

    @Test
    public void trtTestTwo() {
        int a = 1;
        try {
            int c = a / 0;
            a=2;
        } catch (Exception e) {
            // e.printStackTrace();
        }

        System.out.println(a);  //1
    }

}
