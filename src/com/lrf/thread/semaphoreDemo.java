package com.lrf.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 创建人: lirf
 * 创建时间:  2019/5/31 14:15
 * 功能介绍: 信号量 并发控制  案例，比如说排队买票的问题，假如有20个人一起买票，只有两个窗口，怎么实现
 */
public class semaphoreDemo {

    class MyTest implements Runnable {
        private Semaphore semaphore;
        private int user;

        public MyTest(Semaphore semaphore, int user) {
            this.semaphore = semaphore;
            this.user = user;
        }

        @Override
        public void run() {
            try {
                //获取信号量许可才可以占用窗口
//                semaphore.acquire();//尝试获得一个准入的许可。若无法获得，则线程会等待，直到有线程释放一个许可或者当前线程被中断。
//                semaphore.tryAcquire();// 尝试获取，如果成功则为true，否则false。这个方法不会等待，立即返回。
                boolean flag = semaphore.tryAcquire();
                if (!flag) {
                    System.out.println("没有得到资源直接返回");
                    return;
                }
//                System.out.println(flag);
                //运行到这里说明占用了窗口,可以购票
                System.out.println("用户=" + user + "进入窗口,准备买票");
                Thread.sleep((long) (Math.random() * 4000));
                System.out.println("用户=" + user + "买完票,准备离开");
                Thread.sleep((long) (Math.random() * 4000));
                System.out.println("用户=" + user + "买完票,离开");
                semaphore.release();//用于在现场访问资源结束后，释放一个许可，以使其他等待许可的线程可以进行资源访问。
                if (null == semaphore) {
                    System.out.println("semaphore");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void execute(int permits) {
        //定义窗口个数(资源数) permits指定了信号量的准入书，也就是同时能申请多少个许可。当每个线程每次只申请一个许可时，这就相当于指定了同时有多少个线程可以访问某一个资源
        final Semaphore s = new Semaphore(permits);
        //线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            threadPool.execute(new MyTest(s, i + 1));
        }
        threadPool.shutdown();
        System.out.println("---------------------execute结束-------------------------");
    }

    public static void main(String[] args) {
        semaphoreDemo semaphoreDemo = new semaphoreDemo();
        semaphoreDemo.execute(2);
    }

}
