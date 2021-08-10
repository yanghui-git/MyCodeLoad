package com.yh.ThreadLocal;

import org.junit.Test;

/**
 * ThreadLocalMap
 * 底层源码探究
 * <p>
 * 1 底层更像是纯数组形式  没有链表 存储Entry
 * <p>
 * 2 初始容量16  扩容临界值 8   if (size >= threshold - threshold / 4) {
 * System.out.println(size);
 * }
 * 扩容前会先清除一遍旧数据 expungeStaleEntries()
 * <p>
 * 3 扩容size *2    扩容临界值 threshold = newLen * 2 / 3
 */
public class ThreadLocalMapTest {

    @Test
    public void testOne() {
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("thread Local test 1");
        threadLocal.set("thread 2");
        threadLocal.set("thread 3");
        threadLocal.set("thread 4");
        threadLocal.set("thread 5");
        threadLocal.set("thread 6");
        threadLocal.set("thread 7");
        threadLocal.set("thread 8");
        System.out.println(threadLocal.get());
    }

    @Test
    public void testTwo() {
        int size = 8;
        int threshold = 10;
        // 10-10/4=8
        if (size >= threshold - threshold / 4) {
            System.out.println(size);
        }
    }

}
