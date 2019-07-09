package com.lrf.proxy;

/**
 * 创建人: lirf
 * 创建时间:  2019/3/7 9:26
 * 功能介绍: 目标对象
 */
public class UserDao implements IUserDao {

    @Override
    public void save() {
        System.out.println("--目标对象--");
    }
}
