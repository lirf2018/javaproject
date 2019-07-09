package com.lrf.excel;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建人: lirf
 * 创建时间:  2017-10-26 9:25
 * 功能介绍:
 */
public class ReadExcel {

    public static void main(String[] args) {
        Map<String, String> outMap = new HashMap<String, String>();//第三方map
        Map<String, String> inMap = new HashMap<String, String>();//游惠宝map
        try {
            File xlsFile = new File("C:\\Users\\user\\Desktop\\对比明细（提交时间5月22日-9月29日19点46分）.xls");
            // 获得工作簿对象
            Workbook workbook = Workbook.getWorkbook(xlsFile);
            // 获得所有工作表
//            Sheet sheet0 = workbook.getSheet(0);
            Sheet[] sheets = workbook.getSheets();
            for (int i = 0; i < sheets.length; i++) {
                // 获得行数
                int rows = sheets[i].getRows();
                // 获得列数
                int cols = sheets[i].getColumns();
//            System.out.println("获得行数=" + rows + " 获得列数=" + cols);
                // 读取数据
                for (int row = 0; row < rows; row++) {
                    if (i == 0) {
                        String orderNum = sheets[i].getCell(13, row).getContents();
//                        System.out.println("orderNum=" + orderNum);
                        String counts = sheets[i].getCell(7, row).getContents();
//                        System.out.println("counts=" + counts);
                        if (row != 0) {
                            if (null == outMap.get(orderNum.trim())) {
                                outMap.put(orderNum.trim(), counts.trim());
                            } else {
                                System.out.println(row + "重复数据=" + orderNum);
                            }
                        }

                    } else if (i == 1) {
                        String orderNum = sheets[i].getCell(1, row).getContents();
//                        System.out.println("orderNum=" + orderNum);
                        String counts = sheets[i].getCell(14, row).getContents();
//                        System.out.println("counts=" + counts);
                        if (row != 0) {
                            if (null == inMap.get(orderNum.trim())) {
                                inMap.put(orderNum.trim(), counts.trim());
                            } else {
                                System.out.println("UHB重复数据=" + orderNum);
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
            workbook.close();

            //两份数据交集且数据不相等的数据
            Map<String, String> jCount = new HashMap<String, String>();
            //遍历出游惠宝订单在第三方数据里面不存在的数据
            Map<String, String> jUHBOut = new HashMap<String, String>();
            for (Map.Entry<String, String> mapIn : inMap.entrySet()) {
                String keyUHB = mapIn.getKey();//订单号
                String valueUHB = mapIn.getValue();//数量
                if (null != outMap.get(keyUHB)) {
                    String valueOut = outMap.get(keyUHB);
                    if (!valueUHB.equals(valueOut)) {
//                        System.out.println("游惠宝数量不一致--订单号=" + keyUHB + " 游惠宝数量=" + valueUHB + "第三方数量=" + valueOut);
                    }
                } else {
                    //游惠宝订单号找不到
                    System.out.println("游惠宝订单号在第三方数据中找不到=" + keyUHB + "  数量=" + valueUHB);
                }
            }

            for (Map.Entry<String, String> mapOut : outMap.entrySet()) {
                String keyOut = mapOut.getKey();//订单号
                String valueOut = mapOut.getValue();//数量
                if (null == inMap.get(keyOut)) {
                    //第三方订单号找不到
//                    System.out.println("第三方订单号在游惠宝数据中找不到=" + keyOut + "  数量=" + valueOut);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * jxl写Excel
     *
     * @author jianggujin
     */
    public static void JxlWriteDemo() {
        try {
            File xlsFile = new File("d:\\jxl.xls");
            // 创建一个工作簿
            WritableWorkbook workbook = Workbook.createWorkbook(xlsFile);
            // 创建一个工作表
            WritableSheet sheet = workbook.createSheet("sheet1", 0);
            for (int row = 0; row < 10; row++) {
                for (int col = 0; col < 10; col++) {
                    // 向工作表中添加数据
                    sheet.addCell(new Label(col, row, "data" + row + col));
                }
            }
            workbook.write();
            workbook.close();
        } catch (Exception e) {

        }
    }
}
