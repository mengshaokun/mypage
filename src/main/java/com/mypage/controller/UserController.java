package com.mypage.controller;

import com.mypage.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by MSK on 2019/5/27.
 */
@Controller
public class UserController {

    @RequestMapping("/getUserInfo")
    public String getUserInfo(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        model.addAttribute("name", name);
        User user = new User();
        user.setName("张三");
        user.setSex("12");
        model.addAttribute("user",user);
        model.addAttribute("price",12321.12);
        model.addAttribute("date",new Date());

        List userList = new ArrayList<User>();
        User user1 = new User();
        user1.setName("李四");
        user1.setSex("男");
        User user2 = new User();
        user2.setName("王五");
        user2.setSex("女");
        User user3 = new User();
        user3.setName("赵六3123");
        user3.setSex("男");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        model.addAttribute("userList",userList);

        User resumes = new User();
//        resumes.setName("你好");
        resumes.setSex("");
        model.addAttribute("resumes",resumes);

        return "hello";
    }
}
