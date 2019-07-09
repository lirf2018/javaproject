package com.lrf.lock;

/**
 * 创建人: lirf
 * 创建时间:  2019/2/28 16:31
 * 功能介绍:  死锁
 */
public class TestLock {

    private static Object obj1 = new Object();
    private static Object obj2 = new Object();


    public static void main(String[] args) {
        System.out.println("--------------------");
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj1) {
                    try {
                        System.out.println("thread1获取到了obj1");
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj2) {
                        System.out.println("thread1获取到了obj2");
                    }
                }
                System.out.println("thread1获取到了end");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj2) {
                    try {
                        System.out.println("thread2获取到了obj2");
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj1) {
                        System.out.println("thread2获取到了obj1");
                    }
                }
                System.out.println("thread2获取到了end");
            }
        }).start();

        System.out.println("-------------sss-------");
    }

}
