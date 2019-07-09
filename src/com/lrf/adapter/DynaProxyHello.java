package com.lrf.adapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 创建人: lirf
 * 创建时间:  2019/3/19 15:39
 * 功能介绍:  动态代理实现主要是实现InvocationHandler 接口
 */
public class DynaProxyHello implements InvocationHandler {

    private Object target;//目标对象

    /**
     * 通过反射实例化目标对象
     *
     * @param object
     * @return
     */
    public Object bind(Object object) {
        this.target = object;
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("添加额外的方法");//添加额外的方法
        //通过反射机制来运行目标对象的方法
        result = method.invoke(this.target, args);
        System.out.println("end");
        return result;
    }
}
