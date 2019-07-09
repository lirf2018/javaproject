package com.lrf.proxy;

/**
 * 创建人: lirf
 * 创建时间:  2019/3/7 9:31
 * 功能介绍:  静态代理模式测试类
 */
public class ProxyMain {
    public static void main(String[] args) {
        //目标对象
        UserDao target = new UserDao();

        //代理对象,把目标对象传给代理对象,建立代理关系
        UserDaoProxy proxy = new UserDaoProxy(target);
        proxy.save();//执行的是代理的方法
    }
}
