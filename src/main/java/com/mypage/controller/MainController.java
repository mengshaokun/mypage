package com.mypage.controller;

import com.mypage.entity.LinkCategory;
import com.mypage.entity.User;
import com.mypage.service.LinkCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengsk on 2019/5/31.
 *
 * 首页相关
 */
@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private LinkCategoryService linkCategoryService;

    /**
     * 跳转到主页
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/toMain")
    public String toMainPage(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
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
