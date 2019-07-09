package com.lrf.distributed;

/**
 * 创建人: lirf
 * 创建时间:  2018-03-30 17:42
 * 功能介绍: 测试实现的分布式锁
 */
public class ThreadA extends Thread {
    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.seckill();
    }
}

class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Service service = new Service();
            ThreadA threadA = new ThreadA(service);
            threadA.start();
        }
    }
}
