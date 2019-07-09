package com.lrf.day001;

public class SomeThread extends Thread {


    @Override
    public void run() {
        super.run();
        try {
            while (true) {
                this.sleep(1000);
                System.out.println("========>");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        SomeThread oneThread = new SomeThread();
        oneThread.start();
    }
}
