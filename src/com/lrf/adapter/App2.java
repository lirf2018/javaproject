package com.lrf.adapter;

/**
 * 创建人: lirf
 * 创建时间:  2019/3/7 11:25
 * 功能介绍: 对象适配器模式 测试类
 */
public class App2 {

    public static void main(String[] args) {
        Usb1 u = new AdapterApp2(new Usber());
        u.isUsb1();
    }
}
