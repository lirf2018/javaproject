package com.lrf.day005;

/**
 * 创建人: lirf
 * 创建时间:  2018-04-24 17:29
 * 功能介绍:
 */
public abstract class AbstractDemo {

    public String userName;
    public static String id = "1000s";

    public abstract void initMethod();

    public AbstractDemo() {
        System.out.println("-------------");
    }

    public void initMethod1() {
        int i = 0;
    }
}
