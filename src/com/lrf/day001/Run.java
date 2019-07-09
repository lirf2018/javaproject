package com.lrf.day001;

/**
 * 对象锁
 *
 * @author user
 */
public class Run {

    public static void main(String[] args) {

        HasSelfPrivateNum numRef = new HasSelfPrivateNum();

        ThreadA athread = new ThreadA(numRef);
        athread.start();

        ThreadB bthread = new ThreadB(numRef);
        bthread.start();

    }

}

/**
 * 线程不安全
 *
 * @author user
 */
//class HasSelfPrivateNum {
//
//	private int num = 0;
//
//	public void addI(String username) {
//		try {
//			if (username.equals("a")) {
//				num = 100;
//				System.out.println("a set over!");
//				Thread.sleep(2000);
//			} else {
//				num = 200;
//				System.out.println("b set over!");
//			}
//			System.out.println(username + " num=" + num);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//
//}

/**
 * 线程安全(对象锁)
 * @author user
 *
 */
class HasSelfPrivateNum {

    private int num = 0;

    synchronized public void addI(String username) {
        try {
            if (username.equals("a")) {
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println(username + " num=" + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class ThreadA extends Thread {

    private HasSelfPrivateNum numRef;

    public ThreadA(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }

}

class ThreadB extends Thread {

    private HasSelfPrivateNum numRef;

    public ThreadB(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("b");
    }

}
