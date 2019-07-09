package com.lrf.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 创建人: lirf
 * 创建时间:  2019/5/31 16:45
 * 功能介绍:
 */
public class SemaphoreDemo2 implements Runnable {

    private static SemaphoreDemo2 semaphoreDemo2;

    public static SemaphoreDemo2 getInstence() {
        if (semaphoreDemo2 == null) {
            synchronized (SemaphoreDemo2.class) {
                if (null == semaphoreDemo2) {
                    System.out.println("---------初始化semaphoreDemo2");
                    semaphoreDemo2 = new SemaphoreDemo2();
                }
            }
        }
        return semaphoreDemo2;
    }

    private static Semaphore semaphore = new Semaphore(2);


    @Override
    public void run() {

        methodA();
    }

    public static void methodA() {

        try {
            Thread.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        long s = System.currentTimeMillis();
        String st = String.valueOf(s) + Math.random();

        if (!semaphore.tryAcquire()) {
            System.out.println("-------------没有得到资源,结束" + st);
            return;
        }
        try {
            // TODO 方法中的业务逻辑
            System.out.println("----开始处理业务方法" + st);
            Thread.sleep(4000);
            System.out.println("----结束处理业务方法" + st);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }


    private static AtomicInteger counter = new AtomicInteger(0);

    public static void methodB() {
        int value = counter.get();

        System.out.println("-----------------value=" + value);
        if (value > 2) {
            System.out.println("结束");
            return;
        }

        counter.incrementAndGet();

        try {
            // TODO 方法中的业务逻辑
        } finally {
            counter.decrementAndGet();
        }
    }


    public static void main(String[] args) {
//        System.out.println("--------main开始-------------");
//        SemaphoreDemo2 semaphoreDemo2 = SemaphoreDemo2.getInstence();
//        for (int i = 0; i < 3; i++) {
//            Thread t = new Thread(semaphoreDemo2);
//            t.start();
//        }
//        System.out.println("--------main结束-------------");








    }

}
