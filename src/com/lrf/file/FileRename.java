package com.lrf.file;

import java.io.*;
import java.nio.file.Files;

/**
 * 读取文件夹内容并修改文件名称
 */
public class FileRename {

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\usersLi\\Desktop\\自己\\二维码");
        File[] files = file.listFiles();
        int count = 0;
        for (int i = 0; i < files.length; i++) {
            File f = files[i];
            if (f.isFile()) {
                count = count + 1;
                String name = f.getAbsolutePath();
                System.out.println(name);
                String suff = name.split("\\.")[1];
                String fileName = "C:\\Users\\usersLi\\Desktop\\自己\\二维码\\00\\" + count + "." + suff;
                OutputStream out = new FileOutputStream(new File(fileName));
                Files.copy(f.toPath(), out);
            }

        }
        System.out.println("---->" + count);
    }

}
