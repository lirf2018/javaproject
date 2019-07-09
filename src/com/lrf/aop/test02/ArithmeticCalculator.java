package com.lrf.aop.test02;

import org.springframework.stereotype.Component;

/**
 * 创建人: lirf
 * 创建时间:  2019/3/18 18:23
 * 功能介绍:
 */
//@Component("arithmeticCalculator")
public class ArithmeticCalculator {

    public void saying() {
        System.out.println("我是骑士..（切点方法）");
    }
}
