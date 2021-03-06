package com.mypage.dao;

import com.mypage.entity.LinkInfo;
import com.mypage.entity.UserLinkCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by mengsk on 2019/5/31.
 */
@Mapper
public interface UserLinkCategoryDao {

    UserLinkCategory selectByUserIdAndCategoryId(@Param("userId") Integer userId, @Param("linkCategoryId") Integer linkCategoryId);

    void insertUserLinkCategory(UserLinkCategory userLinkCategory);

    void updateLinkInfoById(LinkInfo linkInfo);

}
