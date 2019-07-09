package com.lrf.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 创建人: lirf
 * 创建时间:  2019/3/7 9:59
 * 功能介绍: 1.2 创建动态代理对象
 * 动态代理不需要实现接口,但是需要指定接口类型
 */
public class ProxyFactory {

    private Object target;

    /**
     * 维护一个目标对象
     */
    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 给目标对象生成代理对象
     */
    public Object getProxyInstence() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("--开始事务2--");
                Object returnValue = method.invoke(target, args);
                System.out.println("--结束事务2--");
                return returnValue;
            }
        });
    }

}
