package com.lrf.adapter;

/**
 * 创建人: lirf
 * 创建时间:  2019/3/7 11:27
 * 功能介绍:  接口适配器模式  测试类
 */
public class App3 {

    public static void main(String[] args) {
        UsbN u = new AdapterApp3impl();
        u.a();
        u.d();
    }

}
