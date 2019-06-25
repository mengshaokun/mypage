package com.mypage.controller;

import com.mypage.common.Response;
import com.mypage.entity.User;
import com.mypage.model.request.UserInfoReq;
import com.mypage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by MSK on 2019/6/1.
 *
 * 用户登录注册相关
 */
@Controller
@RequestMapping("/base")
public class BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 用户登录方法
     * @param nickName
     * @param password
     * @param code
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Response login(String nickName, String password, String code, HttpSession session) {
        Response login = userService.login(nickName, password, code);
        if (Response.isSuccess(login)) {
            //查询用户信息并保存到session
            User user = userService.getUserByNickName(nickName);
            session.setAttribute("userInfo", user);
        }
        return login;
    }

    /**
     * 用户注册方法
     * @param userInfoReq
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    @ResponseBody
    public Response regist(@Validated UserInfoReq userInfoReq, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Response.FAIL(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        //注册
        return userService.regist(userInfoReq);
    }
}
