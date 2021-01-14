package com.yh.springboot.search;

import org.springframework.util.StopWatch;

/**
 * https://blog.csdn.net/timchen525/article/details/79647902?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-1.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-1.control
 * StopWatch 计时器
 */
public class StopWatchTest {

    public static void main(String[] args) {
        Long time = System.currentTimeMillis();
        try {
            Thread.sleep(3000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("耗时:    " + (System.currentTimeMillis() - time));

        //StopWatch计时器
        StopWatch stopWatch = new StopWatch("自定义计时器");
        stopWatch.start();
        try {
            Thread.sleep(2000l);
        } catch (Exception e) {

        }
        stopWatch.stop();
        System.out.println("stopwatch :   " + stopWatch.prettyPrint());
    }


}
