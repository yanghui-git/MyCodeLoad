package com.yh.lamada;


import java.util.function.BiFunction;

/**
 * https://blog.csdn.net/u012934325/article/details/86716231
 * Java 1.8 BiFunction
 */
public class BiFunctionTest {
    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> biFunction = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };
        System.out.println(biFunction.apply(3, 6));
        //
        biFunction = (arg1, args2) -> arg1 - args2;
        System.out.println(biFunction.apply(10, 6));
    }


}
