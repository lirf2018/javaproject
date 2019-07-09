package com.lrf.day003;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建人: lirf
 * 创建时间:  2017-07-21 16:46
 * 功能介绍:
 */
public class TestFile {

    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        String strs = "..天天2气、'；{1}aaA你好，!\t\\3";
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < strs.length(); i++) {
            String c = strs.charAt(i) + "";
//            System.out.println(c);
            if (null == map.get(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
//        System.out.println(JSONObject.toJSON(map));
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            System.out.println(m.getKey() + "=" + m.getValue());
        }

    }

    public static void test() {
        String str = "D:\\spark\\pig-0.16.0-src\\pig-0.16.0-src\\ivy";
        String[] path = str.split("\\\\");
        for (int i = path.length - 1; i >= 0; i--) {
            String p = "";
            for (int j = 0; j <= i; j++) {
                p = p + path[j];
                if (j != i) {
                    p = p + "\\";
                }
            }
            System.out.println(p);
        }
    }
}
