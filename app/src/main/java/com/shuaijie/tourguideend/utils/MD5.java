package com.shuaijie.tourguideend.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 认真的人到最后都是难过 2017/12/19.
 */

public class MD5 {
    public static void main(String[] args) {
//        Md5("12312312312312");
        passwordMD5("hahahahha");
    }

    public static String passwordMD5(String password) {
        StringBuilder sb = new StringBuilder();
        try {
            //1.获取数据摘要器
            //arg0 : 加密的方式
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //2.将一个byte数组进行加密,返回的是一个加密过的byte数组,二进制的哈希计算,md5加密的第一步
            byte[] digest = messageDigest.digest(password.getBytes());
            //3.遍历byte数组
            for (int i = 0; i < digest.length; i++) {
                //4.MD5加密
                //byte值    -128-127
                int result = digest[i] & 0xff;
                //将得到int类型转化成16进制字符串
                //String hexString = Integer.toHexString(result)+1;//不规则加密,加盐
                String hexString = Integer.toHexString(result);
                if (hexString.length() < 2) {
//                  System.out.print("0");
                    sb.append("0");
                }
                System.out.print(hexString);
                //e10adc3949ba59abbe56e057f20f883e
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            //找不到加密方式的异常
            e.printStackTrace();
        }
        return null;
    }

    private static void Md5(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }

            System.out.println("result: " + buf.toString());//32位的加密

            System.out.println("result: " + buf.toString().substring(8, 24));//16位的加密

        } catch (NoSuchAlgorithmException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
