package com.mypage.service;

import com.mypage.common.Response;
import com.mypage.entity.User;
import com.mypage.model.request.UserInfoReq;

import java.util.List;

/**
 * Created by mengsk on 2019/5/30.
 */
public interface UserService {

    List<User> getUserList();

    Response login(String nickName, String password, String code);

    User getUserByNickName(String nickName);

    Response regist(UserInfoReq userInfoReq);
}
