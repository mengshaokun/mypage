package com.mypage.controller;

import com.mypage.entity.User;
import com.mypage.model.response.UserLinkInfoResp;
import com.mypage.service.LinkInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by mengsk on 2019/6/14.
 *
 * 链接信息相关
 */
@Controller
@RequestMapping("/personal/linkInfo")
public class LinkInfoController {

    @Autowired
    private LinkInfoService linkInfoService;
    @Value("${user.session.key}")
    private String userSessionKey;


    @RequestMapping(value = "/toLinkInfo")
    public String toLinkInfo(Model model, HttpSession session) {
        User user = (User) session.getAttribute(userSessionKey);
        List<UserLinkInfoResp> userLinkInfo = linkInfoService.getUserLinkInfo(user.getId());
        model.addAttribute("userLinkInfo", userLinkInfo);

        return "linkInfo";
    }

    @RequestMapping(value = "/removeLinkInfo/{id}", method = RequestMethod.GET)
    public String removeLinkInfo(@PathVariable("id") Integer id) {
        linkInfoService.removeLinkUrl(id);
        return "redirect:/personal/linkInfo/toLinkInfo";
    }







}
