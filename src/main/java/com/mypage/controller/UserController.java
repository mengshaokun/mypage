package com.mypage.controller;

import com.mypage.common.Response;
import com.mypage.entity.User;
import com.mypage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by MSK on 2019/5/27.
 *
 * 用户信息相关
 */
@Controller
@RequestMapping("/personal/userInfo")
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${user.session.key}")
    private String userSessionKey;





    @RequestMapping("/getUserInfo")
    public String getUserInfo(Model model, HttpSession session) {
        List<User> userList = userService.getUserList();
        model.addAttribute("userList", userList);
        session.setAttribute("userInfo", userList.get(0));
        return "userList";
    }

    /**
     * 跳转到个人信息页面
     * @return
     */
    @RequestMapping("/toUserInfo")
    public String toUserInfo() {
        return "userInfo";
    }

    /**
     * 修改个人信息
     * @param name
     * @param nickName
     * @param id
     * @param session
     * @return
     */
    @RequestMapping("/modifyUserInfo")
    @ResponseBody
    public Response modifyUserInfo(String name, String nickName, Integer id, HttpSession session) {
        Response response = userService.modifyUserInfo(name, nickName, id);
        if (Response.isSuccess(response)) {
            User user = userService.getUserByNickName(nickName);
            session.setAttribute(userSessionKey, user);
        }
        return response;
    }
}
