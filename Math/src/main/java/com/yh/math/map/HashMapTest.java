package com.yh.math.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * https://blog.csdn.net/zxt0601/article/details/77413921?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_baidulandingword-0&spm=1001.2101.3001.4242
 * HashMap 源码探究
 *
 * https://blog.csdn.net/swpu_ocean/article/details/88917958?utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.baidujs&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.baidujs
 * 如果你去阅读1.8的源码会发现找不到transfer函数，因为JDK1.8直接在resize函数中完成了数据迁移。另外说一句，JDK1.8在进行元素插入时使用的是尾插法
 *
 * 线程不安全体现 1  是否出现hash 碰撞💥       if ((p = tab[i = (n - 1) & hash]) == null)
 *                         tab[i] = newNode(hash, key, value, null);
 *
 *           2    if (++size > threshold)   前缀判断
 *             resize();
 *
    TODO: 2021/7/15   ConcurrentHashMap 源码探究  / java1.7**
 *
 */
public class HashMapTest {

    @Test
    public void testOne(){
        Map map=new HashMap();
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
