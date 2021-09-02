package com.yh.lamada;

import org.junit.Test;

import java.util.*;

public class LamadaMinMax {

    @Test
    public void test() {
        List<Integer> list = Arrays.asList(new Integer[]{
                10, 11, 23, 9, 0, 2, 100
        });
        //默认升序
        //Collections.sort(list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(list);
    }

    /**
     * Lamada 求最大最小
     */
    @Test
    public void testTwo() {
        List<Integer> list = Arrays.asList(new Integer[]{
                10, 11, 23, 9, 0, 2, 100
        });
        Optional optional = list.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(list);
        System.out.println(optional.get());

        List<Integer> list2 = Arrays.asList(new Integer[]{
                90, 0, 100, 200, 44, 88, 33
        });
        System.out.println(list2.stream().min(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }).get());
    }

    /**
     * 绝对值
     */
    @Test
    public void testThree() {
        int a = -1;
        System.out.println(Math.abs(a));
        System.out.println(Math.abs(10));
    }
}
