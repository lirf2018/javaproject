package com.lrf.file;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lrf.rgex.RegexUtil;
import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 创建人: lirf
 * 创建时间:  2017-08-11 10:34
 * 功能介绍:
 */
public class FileRead {


    //    //读取rs_store里面的样式符号
//    public static void main(String[] args) {
//        try {
//            System.out.println("=========================");
//            File inFile = new File("C:\\Users\\usersLi\\Desktop\\catalina.2018-05-14.out");
//            InputStream in = null;
//            try {
//                Map<String, String> map = new HashMap<>();
//                map.put("13640646132", "");
//                map.put("18905933325", "");
//                map.put("13537801014", "");
//                map.put("13817053160", "");
//                map.put("13600277509", "");
//                map.put("18747774443", "");
//                map.put("18666092045", "");
//                map.put("13959138321", "");
//                map.put("18689216844", "");
//                map.put("18682251223", "");
//                map.put("15017876729", "");
//                map.put("13702234403", "");
//                map.put("13760762644", "");
//                map.put("15018915363", "");
//                map.put("13798167007", "");
//                map.put("18520410265", "");
//                map.put("13602604716", "");
//                map.put("15889634173", "");
//                map.put("13723752471", "");
//                map.put("13421306805", "");
//
//                Scanner scanner = new Scanner(inFile);
//                scanner.useDelimiter("\n");
//                while (scanner.hasNext()) {
//                    String line = scanner.next();
//                    if (null != line && !"".equals(line.trim())) {
//                        if (line.indexOf("新接口短信发送结果")>-1) {
//                            System.out.println(line);
//                        }
//                    }
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//                return;
//            }
//
//        } catch (Exception e) {
//
//        }
//    }
    public static void main(String[] args) {
        try {
            System.out.println("=========================");
            File inFile = new File("C:\\Users\\usersLi\\Desktop\\sss.txt");
            InputStream in = null;
            Map<String, String> map = new HashMap<>();

            try {
                Scanner scanner = new Scanner(inFile);
                scanner.useDelimiter("\n");
                while (scanner.hasNext()) {
                    String line = scanner.next();
                    if (null != line && !"".equals(line.trim())) {
                        if (null != line && !"".equals(line)) {
                            if (null == map.get(line)) {
                                map.put(line, line);
                            } else {
                                System.out.println(line);
                            }
                        }

                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

        } catch (Exception e) {

        }
    }

    /**
     * 读出并去掉所有空格
     *
     * @param args
     */
//    public static void main(String[] args) {
//        try {
//            System.out.println("=========================");
//            File inFile1 = new File("C:\\Users\\usersLi\\Desktop\\lbs\\08lbs.log");
//            Map<String, String> map = new HashMap<>();
//            try {
//                Scanner scanner1 = new Scanner(inFile1);
//                scanner1.useDelimiter("\n");
//                while (scanner1.hasNext()) {
//                    String line = scanner1.next();
//                    if (null != line && !"".equals(line.trim())) {
//                        String rgex = "iccid=(.*),data=";
//                        String result = RegexUtil.getInstence().getSubUtilSimple(line, rgex);
//                        map.put(result, result);
//                    }
//                }
//
//                int count = 0;
//                int count1 = 0;
//                File inFile2 = new File("C:\\Users\\usersLi\\Desktop\\lbs\\lbs.log");
//                Scanner scanner2 = new Scanner(inFile2);
//                scanner2.useDelimiter("\n");
//                while (scanner2.hasNext()) {
//                    String line = scanner2.next();
//                    if (null != line && !"".equals(line.trim())) {
//                        String rgex = "iccid=(.*),data=";
//                        String result = RegexUtil.getInstence().getSubUtilSimple(line, rgex);
//                        count = count + 1;
//                        if (map.get(result) != null) {
//                            count1 = count1 + 1;
//                        }
//                    }
//                }
//                System.out.println(count + "---" + count1);
//            } catch (IOException e) {
//                e.printStackTrace();
//                return;
//            }
//
//        } catch (Exception e) {
//
//        }
//        System.out.println("==============end===========");
//    }
    public static void writeFile(String str) {
        try {

            FileOutputStream outputStream = new FileOutputStream(new File("C:\\Users\\usersLi\\Desktop\\上线\\ydui.citys-my.js"));
            BufferedOutputStream buf = new BufferedOutputStream(outputStream);
            buf.write(str.getBytes());
            buf.flush();
            buf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
