package com.lrf.day001;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建人: lirf
 * 创建时间:  2019/1/15 17:22
 * 功能介绍:  商品规格的算法
 */
public class TestDemo2 {


    public static void main(String[] args) {
        JSONArray arrar = new JSONArray();
        //选择的成员
        JSONArray a1 = new JSONArray();
        a1.add("64G");
        a1.add("32G");
//        a1.add("128G");
        arrar.add(a1);

        JSONArray a2 = new JSONArray();
        a2.add("金色");
        a2.add("黑色");
//        a2.add("红色");
        arrar.add(a2);

        JSONArray a3 = new JSONArray();
        a3.add("大陆");
        a3.add("港货");
        arrar.add(a3);

        JSONArray a4 = new JSONArray();
        a4.add("3年");
        a4.add("1年");
        arrar.add(a4);

        generateGroupMy(arrar);
//        List<List<String>> nalllist = new ArrayList<List<String>>();
//        List<String> list1 = new ArrayList<String>();//内存
//        list1.add("64G");
//        list1.add("32G");
////        list1.add("128G");
//        nalllist.add(list1);
//        List<String> list2 = new ArrayList<String>();//颜色
//        list2.add("金色");
//        list2.add("黑色");
////        list2.add("红色");
//        nalllist.add(list2);
//		List<String> list3 = new ArrayList<String>();//产地
//        list3.add("大陆");
//        list3.add("港货");
//        nalllist.add(list3);
//        List<String> list4 = new ArrayList<String>();//保修
//        list4.add("3年");
//        list4.add("1年");
//        nalllist.add(list4);
    }


    public static void generateGroupMy(JSONArray arrar) {
        System.out.println("处理参数--->" + arrar);
        //循环
        int index = arrar.size();
        int beginIndex = 1;//第二组开始
        JSONArray childArr = new JSONArray();//

        JSONArray rootList = arrar.getJSONArray(0);
        if (arrar.size() > 1) {
            for (int i = 0; i < rootList.size(); i++) {
                if (beginIndex >= index) {
                    break;
                }
                JSONArray nextList = arrar.getJSONArray(beginIndex);
                for (int j = 0; j < nextList.size(); j++) {
                    childArr.add(rootList.get(i) + (rootList.get(i).toString().endsWith(";") ? "" : ";") + nextList.get(j) + ";");
                }
                if (i == rootList.size() - 1) {
                    rootList = childArr;
                    childArr = new JSONArray();
                    i = -1;
                    beginIndex++;
                }
            }
        }
        System.out.println("结果:" + rootList.size() + "---->" + rootList);
    }

    public static void generateGroup0(List<List<String>> alllist) {
        System.out.println(alllist.toString());

        List<String> root = alllist.get(0);
        List<String> second = alllist.get(1);


        List<List<String>> value = new ArrayList<List<String>>();

        for (int i = 0; i < root.size(); i++) {
            for (int y = 0; y < second.size(); y++) {
                List<String> child = new ArrayList<String>();
                child.add(root.get(i));
                child.add(second.get(y));
                value.add(child);
            }
        }

        System.out.println("value------------" + value.toString());

        List<List<String>> nvalue = value;
        if (alllist.size() >= 3) {
            for (int i = 2; i < alllist.size(); i++) {
                nvalue = haha1(nvalue, alllist.get(i));
            }
        }

        System.out.println(nvalue.size() + " ---------------- " + nvalue.toString());
    }

    public static List<List<String>> haha1(List<List<String>> value, List<String> second) {
        List<List<String>> nvalue = new ArrayList<List<String>>();
        for (int i = 0; i < value.size(); i++) {
            List<String> child = value.get(i);
            for (int n = 0; n < second.size(); n++) {
                List<String> nchild = new ArrayList<String>();
                nchild.addAll(child);
                String secV = second.get(n);
                nchild.add(secV);
                nvalue.add(nchild);
            }
        }
        return nvalue;
    }


}
