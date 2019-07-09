package com.lrf.day001;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Encrypt {
    public static String Encrypt(String plainText) {
        String result = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result.toUpperCase();
    }


    public static void main(String[] args) {
//		String mobiles = "13113620333";
//		String timestamp = "1490844522179";
//		String account = "ASD666";
//		String passWd = "test1234";
//		String passWdMD5 = MD5Encrypt.Encrypt(passWd);
//		String sign = MD5Encrypt.Encrypt(account+passWdMD5+timestamp+mobiles).toUpperCase();
        System.out.println("111111-------->" + Encrypt("111111"));

    }

}
