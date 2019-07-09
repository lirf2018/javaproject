package com.lrf.file;

import java.util.Random;

/**
 * 创建人: lirf
 * 创建时间:  2017-08-01 18:01
 * 功能介绍:
 */
public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println((int) (Math.random() * 5) + 25);
        }

    }

}
