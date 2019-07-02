package com.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mengsk on 2019/6/28.
 *
 * 个人中心相关
 */
@Controller
@RequestMapping("/personal")
public class PersonalController {

    @RequestMapping("/toPersonal")
    public String toPersonal() {
        return "personal";
    }
}
