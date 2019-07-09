package com.lrf.adapter;

/**
 * 创建人: lirf
 * 创建时间:  2019/3/7 11:09
 * 功能介绍: 类适配器模式 测试
 */
public class App1 {

    public static void main(String[] args) {
        Usb1 u = new AdapterApp1();
        u.isUsb1();
        ((AdapterApp1) u).isUsb();
    }
}
