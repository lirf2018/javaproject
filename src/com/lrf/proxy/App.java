package com.lrf.proxy;

/**
 * 创建人: lirf
 * 创建时间:  2019/3/7 10:15
 * 功能介绍: 动态代理模式测试类
 */
public class App {

    public static void main(String[] args) {
        //目标对象
        IUserDao target = new UserDao();
        // 【原始的类型 class cn.itcast.b_dynamic.UserDao】
        System.out.println(target.getClass());
        // 给目标对象，创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstence();
        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());
        // 执行方法   【代理对象】
        proxy.save();
    }
}
