package com.mypage.dao;

import com.mypage.entity.LinkCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by mengsk on 2019/5/31.
 */
@Mapper
public interface LinkCategoryDao {

    List<LinkCategory> selectLinkCategoryList(@Param("userId") Integer userId);

}
