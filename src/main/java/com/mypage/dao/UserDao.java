package com.mypage.dao;

import com.mypage.entity.User;
import com.mypage.model.request.UserInfoReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by mengsk on 2019/5/30.
 */
@Mapper
public interface UserDao {

    List<User> selectUserList();

    User selectUserByNickName(@Param("nickName") String nickName);

    String selectUserPassword(@Param("userId") Integer userId);

    void insertUserInfo(@Param("user") UserInfoReq user);

    void updateUserInfo(@Param("name") String name, @Param("nickName") String nickName, @Param("id") Integer id);
}
