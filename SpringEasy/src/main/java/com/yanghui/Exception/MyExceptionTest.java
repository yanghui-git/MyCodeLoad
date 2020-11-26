package com.yanghui.Exception;

import org.junit.Test;

public class MyExceptionTest {

    @Test
    public void test(){
        int a=0;
        try {
            a=1/0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }finally {
            System.out.println("666");
        }
    }
}
