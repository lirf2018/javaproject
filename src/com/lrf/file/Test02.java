package com.lrf.file;

import java.io.File;

/**
 * 创建人: lirf
 * 创建时间:  2019/3/5 9:37
 * 功能介绍:
 */
public class Test02 {

    public static void main(String[] args) {
        String path = "E:\\lrf";
        File file = new File(path);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                System.out.println(files[i].getName());
            }

        }
    }


}
