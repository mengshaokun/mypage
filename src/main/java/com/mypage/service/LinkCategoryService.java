package com.mypage.service;

import com.mypage.entity.LinkCategory;

import java.util.List;

/**
 * Created by mengsk on 2019/5/31.
 */
public interface LinkCategoryService {

    List<LinkCategory> getLinkCategoryList(Integer userId);

}
