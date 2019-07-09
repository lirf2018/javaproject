package com.lrf.rgex;

/**
 * 创建人: lirf
 * 创建时间:  2018/12/10 14:28
 * 功能介绍:  正则表达式获取值
 */
public class Test04 {

    public static void main(String[] args) {
        String str = "2018/12/08 00:00:00 [I] lbs respon: time=3.19756ms,imsi=454070005319884,iccid=89852070180003846434,data={\"data\":{},\"resp_code\":1,\"resp_desc\":\"成功\"}";

        String rgex = "iccid=(.*),data=";
        String result = RegexUtil.getInstence().getSubUtilSimple(str, rgex);
        System.out.println(result);

    }
}
