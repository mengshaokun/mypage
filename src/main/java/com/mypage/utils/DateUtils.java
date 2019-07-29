package com.mypage.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mengsk on 2019/7/29.
 */
public class DateUtils {

    public static String getNowDateStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
