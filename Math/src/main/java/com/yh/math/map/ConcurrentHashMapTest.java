package com.yh.math.map;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap源码探究
 * https://blog.csdn.net/strivenoend/article/details/80440884
 *
 *   violate缺点
 * violate无法保证一些符合操作的原子性，用volatile修饰的变量，线程在每次使用变量的时候，都会读取变量修改后的最的值。volatile很容易被误用，用来进行原子性操作。
 *
 * 1 hash key 碰撞  (Node<K,V>)U.getObjectVolatile(tab, ((long)i << ASHIFT) + ABASE) violate
 *
 * 2
 */
public class ConcurrentHashMapTest {

    @Test
    public void testOne(){
        Map map=new ConcurrentHashMap();
        map.put("test1","test1");
        map.put("test2","test2");
        map.put("test3","test1");
        map.put("test4","test2");
        map.put("test5","test1");
        map.put("test6","test2");
        map.put("test7","test1");
        map.put("test8","test2");
        map.put("test9","test1");
        map.put("test10","test2");
        map.put("test11","test1");
        map.put("test12","test2");
        map.put("test13","test1");
        map.put("test14","test2");
        map.put("test15","test1");
        map.put("test16","test2");
        map.put("test17","test1");
        map.put("test18","test2");
        map.put("test19","test1");
        map.put("test20","test2");
        System.out.println(map.get(1));
    }
}
