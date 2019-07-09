package com.lrf.file;

/**
 * 创建人: lirf
 * 创建时间:  2017-08-01 9:16
 * 功能介绍:
 */
public class MyThread {

    public static void main(String[] args) {
//        DataInfo info = new DataInfo();
//        Producer producer = new Producer(info);
//        Consumer consumer = new Consumer(info);
//        new Thread(producer).start();
//        new Thread(consumer).start();
        System.out.println(Math.ceil(2.5));
        System.out.println(Math.floor(2.5));
    }

}

class DataInfo {
    private String title;
    private String contents;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}


class Producer implements Runnable {
    private DataInfo info;

    public Producer(DataInfo info) {
        this.info = info;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                this.info.setTitle("我的公司");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {

                }
                this.info.setContents("游惠宝");
            } else {
                this.info.setTitle("我的学校");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {

                }
                this.info.setContents("北民大");
            }
        }
    }
}

class Consumer implements Runnable {
    private DataInfo info;

    public Consumer(DataInfo info) {
        this.info = info;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {

            }
            System.out.println(this.info.getTitle() + "---->" + this.info.getContents());
        }
    }
}