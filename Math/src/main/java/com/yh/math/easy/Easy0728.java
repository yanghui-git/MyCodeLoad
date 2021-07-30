package com.yh.math.easy;

import org.junit.Test;

import java.util.*;

/**
 * 华为笔试100个人 圈圈*****
 */
public class Easy0728 {

    public static void main(String[] args) {
        game(100, 3);
    }


    public static void game(int person, int num) {
        List<Integer> people = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            people.add(i);
        }
        //记录报数
        int flag = 0;
        //遍历并不断移除
        while (people.size() > num) {
            Iterator iterator = people.iterator();
            while (iterator.hasNext()) {
                int pep = (int) iterator.next();
                //报数+1
                ++flag;
                //达到报数时
                if (flag == num) {
                    System.out.println("即将移除元素...." + pep);
                    //移除
                    iterator.remove();
                    //重置计数
                    flag = 0;
                }
            }
        }
        System.out.println(people);
    }

    /**
     * 错误使用 ConcurrentModificationException
     */
    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        for (int i : list) {
            list.remove(i);
            //  System.out.println(i);
        }
        System.out.println(list);
    }

    /**
     * 边遍历 边删除 Iterator
     */
    @Test
    public void test2() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            int num = (int) iterator.next();
            System.out.println(num);
            //删除元素
            iterator.remove();
        }
        System.out.println("-----");
        System.out.println(list);
    }
}
