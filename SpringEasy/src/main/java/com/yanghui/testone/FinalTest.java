package com.yanghui.testone;

import org.junit.Test;

public class FinalTest {


    public void testOne() {
        System.out.println("testOne");
    }

    public void testTwo() {
        System.out.println("testTwo");

    }

    public final void testThree() {
        System.out.println("testThree");
    }

    class TestFinal extends FinalTest {
        @Override
        public void testOne() {
            // super.testOne();
            System.out.println("testFinalOne");
        }

        @Override
        public void testTwo() {
            super.testTwo();
            System.out.println("testFinalTwo");
        }

        /**
         * testThree()' cannot override 'testThree()' in 'com.yanghui.testone.FinalTest'; overridden method is final
         * final 不可继承
         */
//         @Override
//        public void testThree() {
//           System.out.println("testFinalThree");
//        }
    }

    @Test
    public void FinalTestTT() {
        new TestFinal().testOne();
        System.out.println();
        new TestFinal().testTwo();
        System.out.println();

        FinalTest finalTest = new TestFinal();
        finalTest.testOne();
        System.out.println();
        FinalTest finalTestTwo = new TestFinal();
        finalTestTwo.testTwo();
/**
 * java.lang.ClassCastException: com.yanghui.testone.FinalTest cannot be cast to com.yanghui.testone.FinalTest$TestFinal
 */
//         TestFinal testFinal = (TestFinal) new com.yanghui.testone.FinalTest();
//         testFinal.testOne();

    }
}

