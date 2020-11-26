package com.yanghui.testone;

import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskTest {
public static void main(String[] args){

    TimerTask timerTask =new TimerTask() {
        @Override
        public void run() {
            System.out.println("test");
        }
    };
    Timer timer =new Timer();
    timer.schedule(timerTask,3*1000L,2*1000L);
}

 @Test
    public void timerTest(){
    TimerTask timerTask =new TimerTask() {
        @Override
        public void run() {
            System.out.println("test");
        }
    };
    Timer timer =new Timer();
    timer.schedule(timerTask,3*1000L,2*1000L);
 }

}
