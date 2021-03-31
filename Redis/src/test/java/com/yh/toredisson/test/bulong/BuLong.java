package com.yh.toredisson.test.bulong;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Test;
import sun.nio.cs.UTF_32;

import java.nio.charset.Charset;


/**
 * 布隆过滤器
 * <p>
 * https://blog.csdn.net/qq_38080318/article/details/106207978
 */
public class BuLong {

    @Test
    public void test() {
        //误报率 默认 0.03
        testBL(1000, 2000, null);
        testBL(1000, 3000, null);
        testBL(2000, 5000, null);

        //手动设置 误报率
        testBL(2000, 2000, 0.05d);
        testBL(2000, 3000, 0.00001d);
        testBL(100, 30, 0.2d);
    }


    /**
     * @param total     初始化数据量
     * @param testCount 测试数据量
     * @param failRate  误报率
     */
    public static void testBL(int total, double testCount, Double failRate) {
        BloomFilter<Integer> bf = null;
        if (failRate != null) {
            bf = BloomFilter.create(Funnels.integerFunnel(), total, failRate);
        } else {
            bf = BloomFilter.create(Funnels.integerFunnel(), total);
        }

        //初始化数据到布隆过滤器中
        for (int i = 0; i < total; i++) {
            bf.put(i);
        }

        //判断某值是否存在布隆过滤器中
        double count = 0;
        for (int i = total; i < total + testCount; i++) {
            if (bf.mightContain(i)) {
                count++;
            }
        }
        System.out.println("误报数量" + count + " 误报率 " + count / testCount);
    }


    @Test
    public void test2() {
        BloomFilter<String> bf = BloomFilter.create(Funnels.stringFunnel(Charset.forName("UTF-8")), 1000);
        for (int i = 0; i < 1000; i++) {
            bf.put("haha:" + i);
        }
        int count = 0;
        for (int i = 1000; i < 1000 + 100; i++) {
            if (bf.mightContain("haha" + i)) {
                count++;
            }
        }
        System.out.println("误报数量" + count);

    }
}
