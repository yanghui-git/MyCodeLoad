package com.yh.math.map;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap 源码解析
 */
public class TreeMapTest {

    @Test
    public void test() {

        Map map = new TreeMap();
        map.put("test1", 1);
        map.put("test2", 2);
        map.put("test3", 3);
        System.out.println(map);
    }

}
