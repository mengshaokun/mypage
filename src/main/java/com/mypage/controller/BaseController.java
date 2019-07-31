package com.mypage.controller;

import com.mypage.common.CommonContent;
import com.mypage.common.Response;
import com.mypage.entity.User;
import com.mypage.model.request.UserInfoReq;
import com.mypage.service.UserService;
import com.mypage.utils.CookieUtils;
import com.mypage.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by MSK on 2019/6/1.
 *
 * 基础功能相关
 */
@Controller
@RequestMapping("/base")
@Slf4j
public class BaseController {

    @Autowired
    private UserService userService;

    @Value("${user.session.key}")
    private String userSessionKey;


    @RequestMapping(value = "/toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 用户登录方法
     * @param nickName
     * @param password
     * @param code
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Response login(String nickName, String password, String code, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Response loginResponse = userService.login(nickName, password, code);
        if (Response.isSuccess(loginResponse)) {
            //查询用户信息并保存到session
            User user = userService.getUserByNickName(nickName);
            session.setAttribute(userSessionKey, user);
            log.info(CommonContent.LOGIN_LOG, nickName, DateUtils.getNowDateStr());

            //设置cookie
            CookieUtils.creteCookie(nickName, response);
        }
        return loginResponse;
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
        Response registResponse = userService.regist(userInfoReq);
        if (Response.isSuccess(registResponse)) {
            User userByNickName = userService.getUserByNickName(userInfoReq.getNickName());
            session.setAttribute(userSessionKey, userByNickName);
            log.info(CommonContent.REGIST_LOG, userInfoReq.getNickName(), DateUtils.getNowDateStr());
        }
        return registResponse;
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
     * 用于前端修改个人信息校验昵称是否存在--可以当时登录的昵称一样，需要登录校验
     * @param nickName
     * @return
     */
    @RequestMapping(value = "/personal/checkNickNameIsExist", method = RequestMethod.POST)
    @ResponseBody
    public String personalCheckNickNameIsExist(String nickName, Integer id, HttpSession session) {
        User use = (User) session.getAttribute(userSessionKey);
        if (use != null && nickName.equals(use.getNickName()) && id.equals(use.getId())) {
            return "true";
        }

        User userByNickName = userService.getUserByNickName(nickName);
        if (userByNickName == null) {
            return "true";
        } else {
            return "false";
        }

    }


    /**
     * 退出
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception {
        HttpSession session = request.getSession();
        session.removeAttribute(userSessionKey);
        redirectAttributes.addAttribute("flag", "1");
        return "redirect:/main/toMain";
    }
}
