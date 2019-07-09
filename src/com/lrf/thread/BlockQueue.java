package com.lrf.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建人: lirf
 * 创建时间:  2019/5/31 15:17
 * 功能介绍:
 */
public class BlockQueue {
    private List list = new ArrayList();

    public synchronized Object pop() throws InterruptedException {
        while (list.size() == 0) {
            this.wait();
        }

        if (list.size() > 0) {
            return list.remove(0);
        } else {
            return null;
        }
    }

    public synchronized void put(Object obj) {
        list.add(obj);
        this.notify();
    }
}
