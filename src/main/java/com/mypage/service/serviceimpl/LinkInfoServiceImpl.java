package com.mypage.service.serviceimpl;

import com.mypage.dao.LinkInfoDao;
import com.mypage.dao.UserLinkCategoryDao;
import com.mypage.entity.LinkInfo;
import com.mypage.entity.UserLinkCategory;
import com.mypage.model.request.LinkInfoReq;
import com.mypage.model.response.UserLinkInfoResp;
import com.mypage.service.LinkInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mengsk on 2019/6/14.
 */
@Service
@Slf4j
public class LinkInfoServiceImpl implements LinkInfoService {

    @Autowired
    private LinkInfoDao linkInfoDao;
    @Autowired
    private UserLinkCategoryDao userLinkCategoryDao;

    @Override
    public List<UserLinkInfoResp> getUserLinkInfo(Integer userId) {
        return linkInfoDao.selectUserLinkInfo(userId);
    }

    @Override
    public void removeLinkUrl(Integer id) {
        linkInfoDao.deleteLinkInfo(id);
    }

    @Override
    public void addLinkInfo(LinkInfoReq linkInfoReq) {
        //根据userId和分类id查询用户对应的分类表id，如果查不到，则插入一条用户分类表信息返回id信息
        Integer userLinkCategoryId;
        UserLinkCategory userLinkCategory = userLinkCategoryDao.selectByUserIdAndCategoryId(linkInfoReq.getUserId(), linkInfoReq.getLinkCategoryId());
        if (userLinkCategory == null) {
            userLinkCategory = new UserLinkCategory();
            userLinkCategory.setUserId(linkInfoReq.getUserId());
            userLinkCategory.setLinkCategoryId(linkInfoReq.getLinkCategoryId());
            userLinkCategory.setSortNo(999);
            userLinkCategoryId = userLinkCategoryDao.insertUserLinkCategory(userLinkCategory);
        } else {
            userLinkCategoryId = userLinkCategory.getId();
        }
        LinkInfo linkInfo = new LinkInfo();
        linkInfo.setName(linkInfoReq.getName());
        linkInfo.setUrl(linkInfoReq.getUrl());
        linkInfo.setUserLinkCategoryId(userLinkCategoryId);
        linkInfo.setStatus(linkInfoReq.getStatus());
        linkInfo.setSortNo(linkInfoReq.getSortNo());

        linkInfoDao.insertLinkInfo(linkInfo);
    }
}
