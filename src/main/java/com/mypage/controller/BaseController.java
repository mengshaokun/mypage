package com.mypage.controller;

import com.mypage.common.Response;
import com.mypage.entity.User;
import com.mypage.model.request.UserInfoReq;
import com.mypage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${user.session.key}")
    private String userSessionKey;
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
            session.setAttribute(userSessionKey, user);
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
    public Response regist(@Validated UserInfoReq userInfoReq, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return Response.FAIL(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        //注册
        Response regist = userService.regist(userInfoReq);
        if (Response.isSuccess(regist)) {
            User userByNickName = userService.getUserByNickName(userInfoReq.getNickName());
            session.setAttribute(userSessionKey, userByNickName);
        }
        return regist;
    }

    /**
     * 用于前端校验昵称是否存在
     * @param nickName
     * @return
     */
    @RequestMapping(value = "/checkNickNameIsExist", method = RequestMethod.POST)
    @ResponseBody
    public String checkNickNameIsExist(String nickName) {
        User userByNickName = userService.getUserByNickName(nickName);
        if (userByNickName == null) {
            return "true";
        } else {
            return "false";
        }
    }

    /**
     * 退出
     * @param httpSession
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute(userSessionKey);
        return "redirect:/main/toMain";
    }
}
