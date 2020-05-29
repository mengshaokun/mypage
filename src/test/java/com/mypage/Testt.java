package com.mypage;

import com.mypage.utils.StringUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author mengsk
 * @date 2020/5/29
 */
public class Testt {

    @Test
    public void testStr() throws UnsupportedEncodingException {
//        \u6d4b\u8bd5
//        String s = StringUtils.gbEncoding("测试");
//        System.out.println(s);
//        String s1 = StringUtils.decodeUnicode("\\u6d4b\\u8bd5 test");
//        System.out.println(s1);
        String decode = URLDecoder.decode("{[{src:\u6d4b\u8bd5,dst:test}]}", "utf-8");
        System.out.println(decode);
    }
}
