package com.lrf.aop.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 创建人: lirf
 * 创建时间:  2019/3/18 17:55
 * 功能介绍: aop测试
 */
public class Test02 {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lrf/aop/test02/applicationContext.xml");
//        ArithmeticCalculator arithmeticCalculator = ctx.getBean(ArithmeticCalculator.class);
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
        arithmeticCalculator.saying();
    }
}
