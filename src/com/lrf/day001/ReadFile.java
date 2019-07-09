package com.lrf.day001;

import org.nlpcn.commons.lang.util.StringUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @功能名称
 * @作者 lirongfan
 * @时间 2017年2月17日 上午10:13:16
 */
public class ReadFile {

    public static void main(String[] args) {
        readFile4();
    }

    public static void readFile() {
        Map<String, String> map = readFile2();

        String path = "C:\\Users\\usersLi\\Desktop\\bb.txt";
        File file = new File(path);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                String array[] = tempString.split("\t");
                String s0 = array[0];//订单号
                String s3 = array[3];//状态
                if ((s3.equals("2") && !map.get(s0).equals("S0A")) || (s3.equals("6") && !map.get(s0).equals("S0X"))) {
                    System.out.println(s0 + "------" + s3 + "-------" + map.get(s0));
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    public static Map<String, String> readFile2() {
        Map<String, String> map = new HashMap<>();
        int index = 0;
        String path = "C:\\Users\\usersLi\\Desktop\\aa.txt";
        File file = new File(path);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                String array[] = tempString.split("\t");
                String s0 = array[0];
                String s7 = array[7];
                map.put(s0, s7);
                index++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
//        System.out.println(index);
        return map;
    }

    public static void readFile3() {
        BigDecimal cost = new BigDecimal("0");//花费
        int index = 0;
        List<String> list = new ArrayList<>();
//        BigDecimal all = new BigDecimal(String.valueOf((83050)));//第一份    剩下=76140
//        String path = "C:\\Users\\usersLi\\Desktop\\客路处理\\扣款流水处理\\第一份.txt";

//        BigDecimal all = new BigDecimal(String.valueOf((76140+102883)));//第二份1   剩下=75198
//        String path = "C:\\Users\\usersLi\\Desktop\\客路处理\\扣款流水处理\\第二份1.txt";

//        BigDecimal all = new BigDecimal(String.valueOf((75198)));//第二份2   剩下=3596
//        String path = "C:\\Users\\usersLi\\Desktop\\客路处理\\扣款流水处理\\第二份2.txt";

        BigDecimal all = new BigDecimal(String.valueOf((3596 + 10000)));//第三份   剩下=13431
        String path = "C:\\Users\\usersLi\\Desktop\\客路处理\\扣款流水处理\\第三份.txt";

        File file = new File(path);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                list.add(tempString);
            }

            //
            for (int i = list.size() - 1; i >= 0; i--) {
                String array[] = list.get(i).split("\t");
                String s0 = array[0];//订单号
                String s1 = array[1];//金额
                String s2 = array[2];//时间
//                System.out.println(s0 + "---" + s1 + "---" + s2);
//                cost = cost.add(new BigDecimal(s1));
                index++;
                String PAY_NUMBER = s0;
                String BEFORE_MONEY = all.toString();
                String ADD_MONEY = s1;
                String CREATE_DATE = s2;
                String FINISH_DATE = s2;
                all = all.subtract(new BigDecimal(s1));
                String sql = "INSERT INTO TB_CHAIN_CHANNEL_RECHARGE_RECORD(BEFORE_MONEY,ADD_MONEY,MONEY_TYPE,CHANNEL_ID,TRADE_TYPE,PAY_NUMBER,PAY_OR_CHARGE,STATUS,CREATE_DATE,FINISH_DATE,IF_RETURN_MONEY) VALUES (" + BEFORE_MONEY + "," + ADD_MONEY + ",2,32,8,'" + PAY_NUMBER + "',2,1,'" + CREATE_DATE + "', '" + FINISH_DATE + "',0);";
                System.out.println(sql);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        System.out.println(index + "----all=" + all + "    cost=" + cost);
    }


    public static void readFile4() {
        String path = "C:\\Users\\usersLi\\Desktop\\aa.txt";
        File file = new File(path);
        BufferedReader reader = null;
        int index = 0;
        Map<String, Integer> map = new HashMap<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                if (StringUtil.isNotBlank(tempString)) {
                    String[] array = tempString.split("\t");
                    String s3 = array[3];
                    String s9 = array[9];
                    if ("S0A".equals(s9)) {
                        if (map.get(s3) == null) {
                            map.put(s3, 1);
                        } else {
                            System.out.println(s3);
                        }
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        System.out.println("index===" + index);
    }

}
