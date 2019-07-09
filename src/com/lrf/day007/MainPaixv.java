package com.lrf.day007;

/**
 * 创建人: lirf
 * 创建时间:  2018/11/19 16:35
 * 功能介绍: 数学排序组合
 */
public class MainPaixv {


    public static void main(String[] args) {
        String word = "abc";
        int wordLen = word.length();
        int ucount = 0;//总共的可能组合数
        for (int i = 1; i <= wordLen; i++) {
            ucount = ucount + c(wordLen, i);
        }
        String[] splitArr = new String[wordLen];//拆分成一个词
        for (int i = 0; i < wordLen; i++) {
            String w = word.substring(i, i + 1);
            splitArr[i] = w;
        }
        String[] strCCount = new String[ucount];//所有可能的组合
        //可能的组合
        for (int i = 1; i <= ucount; i++) {
            String cw = "";//组合词
            for (int j = 0; j < splitArr.length; j++) {

                if (j > i) {
                    break;
                }
            }
        }

    }

    /**
     * 组合结果
     *
     * @param a 下标
     * @param b 上标
     * @return
     */
    public static int c(int a, int b) {
        int da = 1;
        int xiao = 1;
        for (int i = 0; i < b; i++) {
            da = da * a;
            a--;
        }
        for (; b > 0; b--) {
            xiao = xiao * b;
        }
        return da / xiao;
    }

}
