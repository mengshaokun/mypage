package com.mypage.controller;

import com.mypage.common.CommonContent;
import com.mypage.entity.LinkCategory;
import com.mypage.entity.User;
import com.mypage.service.LinkCategoryService;
import com.mypage.service.UserService;
import com.mypage.utils.CookieUtils;
import com.mypage.utils.SignUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengsk on 2019/5/31.
 *
 * 首页相关
 */
@Controller
public class MainController {

    @Autowired
    private LinkCategoryService linkCategoryService;
    @Autowired
    private UserService userService;

    @Value("${user.session.key}")
    private String userSessionKey;
    /**
     * 跳转到主页
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/main")
    public String toMainPage(Model model, String flag, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        //获取cookie
        Cookie[] cookies = request.getCookies();
        String userName = "";
        String ssid = "";
        boolean equals = false;
//        System.out.println(flag);
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (!"1".equals(flag)) {
                    if (cookie.getName().equals("userName")) {
                        userName = cookie.getValue();
                    }
                    if (cookie.getName().equals("ssid")) {
                        ssid = cookie.getValue();
                    }
                } else {
                    //flag=1 标识退出操作
                    if (cookie.getName().equals("userName") || cookie.getName().equals("ssid")) {
                        cookie.setValue("");
                        cookie.setMaxAge(0);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                    }
                }

            }
        }

        if (userName != null && ssid != null) {
            equals = ssid.equals(SignUtils.md5(CommonContent.KEY + userName));
        }

        if (equals) {
            //自动登录
            User user = userService.getUserByNickName(userName);
            if (user != null) {
                session.setAttribute(userSessionKey, user);
            }
        }

        User user = (User) session.getAttribute(userSessionKey);
        List<LinkCategory> linkCategoryList = new ArrayList<>();
        if (user == null) {
            //游客身份，展示public数据
            //public公共用户id固定为1
            linkCategoryList = linkCategoryService.getLinkCategoryList(1);
        } else {
            //用户身份，展示用户设置的数据
            linkCategoryList = linkCategoryService.getLinkCategoryList(user.getId());
        }
        model.addAttribute("linkCategoryList", linkCategoryList);
        return "main";
    }
}
