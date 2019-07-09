package com.lrf.aop.test01;

/**
 * 创建人: lirf
 * 创建时间:  2019/3/19 10:43
 * 功能介绍:
 */
public class HelloWorldImpl1 implements HelloWorld {
    @Override
    public void printHelloWorld() {
        System.out.println("Enter HelloWorldImpl1.printHelloWorld()");
    }

    @Override
    public void doPrint() {
        System.out.println("Enter HelloWorldImpl1.doPrint()");
        return;
    }
}

