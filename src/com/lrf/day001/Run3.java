package com.lrf.day001;

/**
 * 同步块 非this对象
 *
 * @author user
 */
public class Run3 {

    public static void main(String[] args) {

        Service service = new Service("xiaobaoge");

        ThreadA3 a = new ThreadA3(service);
        a.setName("A");
        a.start();

        ThreadB3 b = new ThreadB3(service);
        b.setName("B");
        b.start();

    }

}

class Service {

    String anyString = new String();

    public Service(String anyString) {
        this.anyString = anyString;
    }

    public void setUsernamePassword(String username, String password) {
        try {
            synchronized (anyString) {
                System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入同步块");
                Thread.sleep(3000);
                System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开同步块");
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

class ThreadA3 extends Thread {
    private Service service;

    public ThreadA3(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.setUsernamePassword("a", "aa");

    }

}

class ThreadB3 extends Thread {

    private Service service;

    public ThreadB3(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.setUsernamePassword("b", "bb");

    }

}