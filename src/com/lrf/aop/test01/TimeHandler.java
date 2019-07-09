package com.lrf.aop.test01;

/**
 * 创建人: lirf
 * 创建时间:  2019/3/19 10:44
 * 功能介绍:  横切关注点，这里是打印时间
 */
public class TimeHandler {

    public void printTime() {
        System.out.println("CurrentTime = " + System.currentTimeMillis());
    }
}
