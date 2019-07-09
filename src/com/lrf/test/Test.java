package com.lrf.test;

/**
 * 创建人: lirf
 * 创建时间:  2019/4/1 17:30
 * 功能介绍:
 */
public class Test {
    public static int staticVar = 0;
    public int instanceVar = 0;
    public Test(){
        staticVar++;
        instanceVar++;
        System.out.println("staticVar=" + staticVar + ",instanceVar=" + instanceVar);
    }

    public static void main(String[] args) {
        int i = 1;
        int j1 = i++;
        System.out.println("j1=" + j1); // 输出 j1=1
        System.out.println("i=" + i); // 输出 i=2

    }



}

