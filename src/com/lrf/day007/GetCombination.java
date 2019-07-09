package com.lrf.day007;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 创建人: lirf
 * 创建时间:  2018/11/19 17:45
 * 功能介绍:
 */
public class GetCombination {
    public static void main(String[] args) {
        long st = System.currentTimeMillis();
//        Scanner scan = new Scanner(new BufferedInputStream(System.in));
//        String s = scan.next();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Character> com = new ArrayList<>();
        String s = "香港百老汇优惠券";


        int len = s.length() + 1;
        for (int i = 1; i != len; i++) {
            getCombinations(list, s.toCharArray(), 0, i, com);
        }
        for (int i = 0; i != list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(getCountOfCombinations(s.length(), s.length()));
//        scan.close();
        long et = System.currentTimeMillis();
        System.out.println("用时: " + (et - st));
    }

    static void getCombinations(ArrayList<String> list, char[] cs, int start, int len, ArrayList<Character> com) {//len为组合的长度
        if (len == 0) {
            String s = "";
            for (int i = 0; i != com.size(); i++) {
                s = s.concat(com.get(i).toString());
            }
            list.add(s);
            return;
        }
        if (start == cs.length) {
            return;
        }
        com.add(cs[start]);
        getCombinations(list, cs, start + 1, len - 1, com);
        com.remove(com.size() - 1);
        getCombinations(list, cs, start + 1, len, com);
    }

    static int getCountOfCombinations(int arrLen, int len) {//获取长度为len的组合数
        int m = 1;
        for (int i = 0; i != len; i++) {
            m *= arrLen - i;
        }
        int n = 1;
        for (int i = len; i != 1; i--) {
            n *= i;
        }
        return m / n;
    }

}
