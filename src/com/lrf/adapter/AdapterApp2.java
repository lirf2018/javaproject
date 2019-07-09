package com.lrf.adapter;

/**
 * 创建人: lirf
 * 创建时间:  2019/3/7 11:22
 * 功能介绍: 对象适配器模式
 */
public class AdapterApp2 implements Usb1 {

    private Usber usber;

    public AdapterApp2(Usber usber) {
        this.usber = usber;
    }

    @Override
    public void isUsb1() {
        usber.isUsb();
        System.out.println("--isUsb1--");
    }
}
