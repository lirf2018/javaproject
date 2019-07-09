package com.lrf.aop.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 创建人: lirf
 * 创建时间:  2019/3/19 10:47
 * 功能介绍:
 */
public class Test01 {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("./com/lrf/aop/test01/applicationContext.xml");
        HelloWorld hw1 = (HelloWorld) ctx.getBean("helloWorldImpl1");
//        HelloWorld hw2 = (HelloWorld) ctx.getBean("helloWorldImpl2");
        hw1.printHelloWorld();
        System.out.println();
        hw1.doPrint();

//        System.out.println();
//        hw2.printHelloWorld();
//        System.out.println();
//        hw2.doPrint();
    }
}
