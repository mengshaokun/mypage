package com.mypage.dao;

import com.mypage.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by mengsk on 2019/5/30.
 */
@Mapper
public interface UserDao {

    List<User> selectUserList();

}
