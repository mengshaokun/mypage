package com.mypage.controller;

import com.mypage.entity.User;
import com.mypage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by MSK on 2019/5/27.
 *
 * 用户信息相关
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserInfo")
    public String getUserInfo(Model model) {
        List<User> userList = userService.getUserList();
        model.addAttribute("userList", userList);
        return "userList";
    }
}
