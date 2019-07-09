package com.lrf.day005;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * 创建人: lirf
 * 创建时间:  2018-04-24 17:38
 * 功能介绍:
 */
public class AbstractDemoMain extends AbstractDemo {

    @Override
    public void initMethod() {
        System.out.println("========================1");
    }

    public static void main(String[] args) {
        Map map = new Hashtable();
        map.put(1, "sadfs");

        Map map2 = new HashMap();
        map2.put(null, "dsaf");
    }
}
