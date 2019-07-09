package com.lrf.feature;

/**
 * 创建人: lirf
 * 创建时间:  2019/3/7 13:47
 * 功能介绍:
 */
public class Son extends ParentA {
    /**
     * @param a
     * @return void
     * @desc 子类重载父类方法
     * 父类中不存在该方法，向上转型后，父类是不能引用该方法的
     */
    public void fun1(String a) {
        System.out.println("Son 的 Fun1...");
        fun2();
    }

    /**
     * 子类重写父类方法
     * 指向子类的父类引用调用fun2时，必定是调用该方法
     */
    public void fun2() {
        System.out.println("Son 的Fun2...");
    }
}
