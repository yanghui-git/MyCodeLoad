package com.yh.math.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * HashSet源码探究
 */
public class HashSetTest {

    @Test
    public void testOne(){
        Set set=new HashSet();
        set.add("test1");
        set.add("test2");
        set.add("test3");
        set.add("test1");
        System.out.println(set);
    }
}
