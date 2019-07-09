package com.lrf.day001;

import java.util.Random;

/**
 * 创建人: lirf
 * 创建时间:  2019/3/6 16:39
 * 功能介绍:
 */
public class Test20190306 {

    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            System.out.println(r.nextInt(10));
        }
    }
}
