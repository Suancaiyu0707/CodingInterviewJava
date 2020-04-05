package com.xuzf;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/5 3:48 下午
 * @Description
 */
public class TestTimer {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws Exception{
        testTimer();
        test2();
    }
    public static void testTimer(){

        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("task1 Date= "+sdf.format(new Date()));
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },1000);
//
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("task2 Date= "+sdf.format(new Date()));
//            }
//        },1000);
//
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("task3 Date= "+sdf.format(new Date()));
//            }
//        },1000);

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("scheduleTask1 Date= "+sdf.format(new Date()));
                System.out.println("Thread:"+Thread.currentThread().getName());
            }
        },50,500);


        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("scheduleTask2 Date= "+sdf.format(new Date()));
                System.out.println("Thread:"+Thread.currentThread().getName());
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        },50,1000);
    }

    public static void test2() throws Exception{
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(),1);
        Thread.sleep(1000);
        timer.schedule(new ThrowTask(),1);
        Thread.sleep(5000);
    }

    protected static class ThrowTask extends TimerTask{

        @Override
        public void run() {
            throw new RuntimeException();
        }
    }
}
