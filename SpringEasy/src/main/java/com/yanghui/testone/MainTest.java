package com.yanghui.testone;

import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;

public class MainTest {

    @Test
    public void timeTest() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("11111");
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, 3000L);
    }

    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                System.out.println("666");
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 5000L, 3L);
    }
}
