package com.mypage.service.serviceimpl;

import com.mypage.dao.UserDao;
import com.mypage.entity.User;
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
}
