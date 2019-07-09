package com.lrf.proxy;

/**
 * 创建人: lirf
 * 创建时间:  2019/3/7 9:29
 * 功能介绍: 代理对象,静态代理
 */
public class UserDaoProxy implements IUserDao {

    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开始事务...");
        target.save();//执行目标对象的方法
        System.out.println("提交事务...");
    }
}
