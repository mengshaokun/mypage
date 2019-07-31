package com.mypage.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by mengsk on 2019/7/30.
 */
public class SignUtils {
    private static final String KEY = "sign_key";

    public static String md5Encrypt(String str) {
        str= (str==null)?"":(str+KEY);
        char[] md5Digst = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};//字典

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");//MD5  sha1
            byte[] strArr = str.getBytes();
            md.update(strArr);//把明文放到MessageDigest的对象中，更新数据
            byte[] msg = md.digest();//加密操作
            //进一步加密
            int len = msg.length;

            char[] result = new char[len*2];
            int k = 0;

            for(int i = 0; i < len; i++) {
                byte b = msg[i];
                result[k++] = md5Digst[b>>4 & 0xf];
                result[k++] = md5Digst[b & 0xf];
            }
//            System.out.println(result);
            return new String(result);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
