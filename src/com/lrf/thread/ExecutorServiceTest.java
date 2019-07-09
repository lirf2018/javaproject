package com.lrf.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 创建人: lirf
 * 创建时间:  2019/6/11 16:53
 * 功能介绍:
 */
public class ExecutorServiceTest {

    public static void main(String[] args) {
        //创建一个线程池，根据需要创建新的线程，但在可用时将重用先前构建的线程。
        ExecutorService executorService = Executors.newCachedThreadPool();

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("------,.k.,");
            }
        },2*1000, TimeUnit.MILLISECONDS);
        scheduledExecutorService.shutdown();
    }


}
