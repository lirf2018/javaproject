package com.lrf.file;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lrf.util.DateUtil;

import java.io.*;
import java.util.*;

import static javax.print.attribute.standard.MediaSizeName.C;

/**
 * 查询电信号码是否开通国际漫游
 */
public class FileDoPackage {


    public static void main(String[] args) {
        //得到所有电信未开通国际漫游的手机号码
//        filterLog();
        //复制得到的结果到一个文件中然后去重，得到结果
//        distinctPhone();
        //处理订单数据，得到成功购买订单电信境外流量包的订单数据（一份订单数据库道出数据（orderId,orderType,status,createdate），
        // 一份订单详情导出数据（orderId,phone））整合成一份数据-->成功订购的所有手机号码
//        doOrderSucces();
        //从未开通国际漫游的手机号中得到相同手机定购成功的
//        comparePhone();
        //去重最终结果
        distinctResult();

    }

    public static void distinctResult() {
        try {
            System.out.println("=========================");
            //订购成功的手机号码
            Map<String, String> telecomSuccessOrder = new HashMap<>();
            Map<String, String> testPhoneMap = new HashMap<>();
            List<String> list = new ArrayList<>();
            int count = 0;
            File inFile = new File("C:\\Users\\usersLi\\Desktop\\log\\result.log");

            Scanner scanner = new Scanner(inFile);
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                String line = scanner.next();
                if (null != line && !"".equals(line.trim())) {
                    if (null == telecomSuccessOrder.get(line)) {
                        String key = line.trim();

                        //
                        String date = line.split("#")[0];
                        String testPhone = line.split("#")[1];
//                        if (null != testPhoneMap.get(testPhone)) {
////                            System.out.println(testPhone);
//                        }else{
//                            testPhoneMap.put(testPhone,testPhone);
//                        }
                        if (telecomSuccessOrder.get(key) == null) {

                            if (date.length() > 10) {
                                System.out.println(line);
                            }
                            count = count + 1;
                            telecomSuccessOrder.put(key, key);
                            list.add(line + "\n");
                        }
                    }
                }
            }
//            resultWrite(list);
            System.out.println("----订单数据-->" + count);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }


    public static void comparePhone() {
        try {
            System.out.println("=========================");
            //订购成功的手机号码
            Map<String, String> telecomSuccessOrder = new HashMap<>();

            int count = 0;
            File inFile = new File("C:\\Users\\usersLi\\Desktop\\log\\successOrderPhone.txt");
            Map<String, String> phoneMap = new HashMap<String, String>();
            Scanner scanner = new Scanner(inFile);
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                String line = scanner.next();
                if (null != line && !"".equals(line.trim())) {
                    telecomSuccessOrder.put(line, line);
//                    count = count + 1;
                }
            }
//            System.out.println(count);

            //未开通国际漫游的
            File inFileN = new File("C:\\Users\\usersLi\\Desktop\\log\\nopassPhone.txt");
            Scanner scannerN = new Scanner(inFileN);
            scannerN.useDelimiter("\n");
            while (scannerN.hasNext()) {
                String line = scannerN.next();
                if (null != line && !"".equals(line.trim())) {
                    if (null != telecomSuccessOrder.get(line)) {
                        System.out.println(line);
                        count = count + 1;
                    }
                }
            }
            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }


    public static void doOrderSucces() {
        try {
            System.out.println("=========================");
            try {
                Map<Integer, Integer> telecomSuccessOrder = new HashMap<>();
                //订单数据
                File inFileO = new File("C:\\Users\\usersLi\\Desktop\\log\\TB_CHAIN_ORDER.txt");
                Scanner scannerO = new Scanner(inFileO);
                scannerO.useDelimiter("\n");
                int orderCount = 0;
                while (scannerO.hasNext()) {
                    String line = scannerO.next();
                    if (null != line && !"".equals(line.trim())) {
                        String orderArray[] = line.split(";");
                        int orderId = Integer.parseInt(orderArray[0]);
                        String orderType = orderArray[1];
                        String status = orderArray[2];
                        String createDateTime = orderArray[3];
                        String date = DateUtil.convertDateToStr(DateUtil.convertStrToDate(createDateTime, "yyyy-mm-dd"), "yyyy-mm-dd");
                        String date_2018_05 = DateUtil.convertDateToStr(DateUtil.convertStrToDate(createDateTime, "yyyy-mm-dd"), "yyyy-mm");
                        //5月份订单数据+成功的订单+电信的订单
                        if ("2018-05".equals(date_2018_05) && "2".equals(status) && "telecom_flow".equals(orderType)) {
//                            orderCount = orderCount + 1;
                            telecomSuccessOrder.put(orderId, orderId);
                        }
                    }
                }

                List<String> list = new ArrayList<>();

                //订单详情数据
                File inFileD = new File("C:\\Users\\usersLi\\Desktop\\log\\TB_CHAIN_ORDER_DOMESTICFLOW_DETAIL.txt");
                Scanner scannerD = new Scanner(inFileD);
                scannerD.useDelimiter("\n");
                while (scannerD.hasNext()) {
                    String line = scannerD.next();
                    if (null != line && !"".equals(line.trim())) {
                        String orderArray[] = line.split(";");
                        int orderId = Integer.parseInt(orderArray[0]);
                        String phone = orderArray[1];
                        if (null != telecomSuccessOrder.get(orderId)) {
                            orderCount = orderCount + 1;
//                            list.add(phone + "");
//                            System.out.println("成功订购的手机号码-" + phone);
//                            System.out.println(phone);
                        }
                    }
                }
                System.out.println("----订单数据-->" + orderCount);

            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

        } catch (Exception e) {

        }
    }


    //查询手机是否开通国际漫游---去重手机号码
    public static void distinctPhone() {
        try {
            System.out.println("=========================");
            File inFile = new File("C:\\Users\\usersLi\\Desktop\\log\\result.txt");
            try {
                Map<String, String> phoneMap = new HashMap<String, String>();
                Scanner scanner = new Scanner(inFile);
                scanner.useDelimiter("\n");
                while (scanner.hasNext()) {
                    String line = scanner.next();
                    if (null != line && !"".equals(line.trim())) {
                        String lineArray[] = line.split("-");
                        String phone = lineArray[0];
                        if (null == phoneMap.get(phone)) {
                            System.out.println(phone);
                        } else {
                            phoneMap.put(phone, phone);
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


    //查询手机是否开通国际漫游
    public static void filterLog() {
        try {
            System.out.println("=========================");
            File inFile = new File("C:\\Users\\usersLi\\Desktop\\log\\9.3\\test.log5");
            try {
                List<String> list = new ArrayList<>();
                Map<String, String> phoneMap = new HashMap<String, String>();
                Scanner scanner = new Scanner(inFile);
                scanner.useDelimiter("\n");
                while (scanner.hasNext()) {
                    String line = scanner.next();
                    if (null != line && !"".equals(line.trim())) {
                        if (line.indexOf("询用户是否开通国漫调用电信查询接口返回参数{") > -1 && line.indexOf("连接失败，请稍后重") < 0) {
                            String lineArray[] = line.split("查询用户是否开通国漫调用电信查询接口返回参数");
                            String time = line.split(" ")[0];
                            String result = lineArray[1];
                            JSONObject resultJson = JSONObject.parseObject(result);
                            String resultCode = resultJson.getString("result_code");
                            String phone = resultJson.getString("phone_id");

                            if ("00000".equals(resultCode)) {
                                String data = resultJson.getString("data");
                                JSONArray array = JSON.parseArray(data);
                                for (int i = 0; i < array.size(); i++) {
                                    JSONObject dateValue = array.getJSONObject(i);
                                    String funcId = dateValue.getString("func_id");
                                    String funcStatus = dateValue.getString("func_status");

                                    String key = time + "#" + phone;

                                    if ("1001".equals(funcId) && "1".equals(funcStatus)) {
                                        //已开通国际漫游
                                        if (null != phoneMap.get(key)) {
                                            phoneMap.remove(key);
                                        }
                                    } else if ("1001".equals(funcId) && "0".equals(funcStatus)) {
                                        phoneMap.put(key, key);
                                    }
                                }
                            }
                        }
                    }
                }
                for (Map.Entry<String, String> map : phoneMap.entrySet()) {
                    list.add(map.getKey() + "\n");
                }
                System.out.println(list.size());
                resultWrite(list);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

        } catch (Exception e) {

        }
    }

    public static void resultWrite(List<String> list) {
        try {
            BufferedOutputStream buff = null;
            FileOutputStream outFile = new FileOutputStream("C:\\Users\\usersLi\\Desktop\\log\\data.log");
            buff = new BufferedOutputStream(outFile);
            for (int i = 0; i < list.size(); i++) {
                buff.write(list.get(i).getBytes());
            }
            buff.flush();
            buff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
