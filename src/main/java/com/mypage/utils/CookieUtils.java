package com.mypage.utils;

import com.mypage.common.CommonContent;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by mengsk on 2019/7/30.
 */
public class CookieUtils {

    //默认cookie有效时间
    private static final Integer DEFAULT_TIME = 7*24*60*60;

    /**
     * 设置cookie
     * @param userName
     * @param response
     */
    public static void creteCookie(String userName, HttpServletResponse response) {
        Cookie userCookie = new Cookie("userName", userName);
        Cookie ssidCookie = new Cookie("ssid", SignUtils.md5(CommonContent.KEY + userName));
        userCookie.setMaxAge(DEFAULT_TIME);
        ssidCookie.setMaxAge(DEFAULT_TIME);
        userCookie.setPath("/");
        ssidCookie.setPath("/");
        response.addCookie(userCookie);
        response.addCookie(ssidCookie);

    }

}
