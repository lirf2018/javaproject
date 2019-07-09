package com.lrf.feature;

/**
 * 创建人: lirf
 * 创建时间:  2019/3/7 13:47
 * 功能介绍: 多态测试类
 */
public class App {

    public static void main(String[] args) {

        //向上转型
        ParentA parentA = new Son();
//        parentA.fun1();

        //向下转型
        Son son = (Son) parentA;
        son.fun1();

    }
}
