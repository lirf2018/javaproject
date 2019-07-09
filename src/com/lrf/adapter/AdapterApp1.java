package com.lrf.adapter;

/**
 * 创建人: lirf
 * 创建时间:  2019/3/7 11:10
 * 功能介绍:  类适配器模式
 */
public class AdapterApp1 extends Usber implements Usb1 {
    @Override
    public void isUsb1() {
        System.out.println("--udb1--");
    }
}
