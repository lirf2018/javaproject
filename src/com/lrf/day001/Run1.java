package com.lrf.day001;

/**
 * 同步块this对象
 *
 * @author user
 */
public class Run1 {

    public static void main(String[] args) {
        ObjectService service = new ObjectService();

        ThreadA1 a = new ThreadA1(service);
        a.setName("a");
        a.start();

        ThreadB1 b = new ThreadB1(service);
        b.setName("b");
        b.start();
    }

}

class ObjectService {
    public void serviceMethod() {
        try {
            synchronized (this) {
                System.out.println("begin time=" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("end    end=" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA1 extends Thread {

    private ObjectService service;

    public ThreadA1(ObjectService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.serviceMethod();
    }

}

class ThreadB1 extends Thread {
    private ObjectService service;

    public ThreadB1(ObjectService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.serviceMethod();
    }
}
