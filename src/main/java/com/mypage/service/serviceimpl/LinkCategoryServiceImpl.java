package com.mypage.service.serviceimpl;

import com.mypage.dao.LinkCategoryDao;
import com.mypage.entity.LinkCategory;
import com.mypage.service.LinkCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mengsk on 2019/5/31.
 */
@Service
public class LinkCategoryServiceImpl implements LinkCategoryService {

    @Autowired
    private LinkCategoryDao linkCategoryDao;

    @Override
    public List<LinkCategory> getLinkCategoryList(Integer userId) {
        return linkCategoryDao.selectLinkCategoryList(userId);
    }
}
