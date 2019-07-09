package com.lrf.day001;

/**
 * 静态synchronized同步方法
 *
 * @author user
 */
public class Run2 {
    public static void main(String[] args) {

        ThreadA2 a = new ThreadA2();
        a.setName("A");
        a.start();

        ThreadB2 b = new ThreadB2();
        b.setName("B");
        b.start();
        System.out.println("=======");

    }

}

class Service1 {

    synchronized public static void printA() {
        try {
            System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入printA");
            Thread.sleep(3000);
            System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开printA");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public static void printB() {
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入printB");
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开printB");
    }

}


class ThreadA2 extends Thread {
    @Override
    public void run() {
        Service1.printA();
    }

}


class ThreadB2 extends Thread {
    @Override
    public void run() {
        Service1.printB();
    }
} 