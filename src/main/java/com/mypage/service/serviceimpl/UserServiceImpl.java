package com.mypage.service.serviceimpl;

import com.mypage.common.CommonContent;
import com.mypage.common.Response;
import com.mypage.dao.UserDao;
import com.mypage.entity.User;
import com.mypage.model.request.UserInfoReq;
import com.mypage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mengsk on 2019/5/30.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserList() {
        return userDao.selectUserList();
    }

    @Override
    public Response login(String nickName, String password, String code) {
        User user = userDao.selectUserByNickName(nickName);
        //校验验证码

        //校验用户是否存在
        if (user == null) {
            return Response.FAIL(CommonContent.USER_NULL);
        }
        //校验用户状态
        if (user.getStatus() != 1) {
            return Response.FAIL(CommonContent.USER_WRONG_STATUS);
        }
        //校验密码
        String pwd = userDao.selectUserPassword(user.getId());
        if (!pwd.equals(password)) {
            return Response.FAIL(CommonContent.PASSWORD_ERROR);
        }
        return Response.SUCCESS(CommonContent.LOGIN_SUCCESS);
    }

    @Override
    public User getUserByNickName(String nickName) {
        return userDao.selectUserByNickName(nickName);
    }

    @Override
    public Response regist(UserInfoReq userInfoReq) {
        try {
            //处理密码

            //保存数据
            userDao.insertUserInfo(userInfoReq);
        } catch (Exception e) {
            return Response.FAIL(e);
        }
        return Response.SUCCESS(CommonContent.REGIST_SUCCESS);
    }

    @Override
    public Response modifyUserInfo(String name, String nickName, Integer id) {
        userDao.updateUserInfo(name, nickName, id);
        return Response.SUCCESS(CommonContent.UPDATE_SUCCESS);
    }
}
