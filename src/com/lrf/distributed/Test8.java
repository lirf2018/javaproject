package com.lrf.distributed;
/**
 * 分布锁测试
 */

import java.util.UUID;

public class Test8 {

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            MyTask task = new MyTask(i);
            new Thread(task).start();
        }
    }

}

class MyTask implements Runnable {
    private int index;

    public MyTask(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        String key = "mytestkey";
        String uuid = UUID.randomUUID().toString();
        while (!JedisUtil.lock(key, uuid)) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        System.out.println(new Date() + " start-" + index);
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(new Date() + " working-" + index);
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        test();
//        System.out.println(new Date() + " end-" + index);
        JedisUtil.unlock(key, uuid);
    }


    public void test() {
        System.out.println("-----------A");

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("-----------B");
    }

}
