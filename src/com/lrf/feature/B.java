package com.lrf.feature;

/**
 * 创建人: lirf
 * 创建时间:  2019/3/7 14:35
 * 功能介绍:
 */
public class B extends A {
    public String show(B obj) {
        return ("B and B");
    }

    public String show(A obj) {
        return ("B and A");
    }
}
