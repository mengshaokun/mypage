package com.mypage.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mypage.common.CommonContent;
import com.mypage.common.Response;
import com.mypage.dao.LinkInfoDao;
import com.mypage.dao.UserLinkCategoryDao;
import com.mypage.entity.LinkInfo;
import com.mypage.entity.LinkInfoExport;
import com.mypage.entity.User;
import com.mypage.entity.UserLinkCategory;
import com.mypage.model.request.LinkInfoReq;
import com.mypage.model.request.ModifyLinkInfoReq;
import com.mypage.model.response.UserLinkInfoResp;
import com.mypage.service.LinkInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mengsk on 2019/6/14.
 */
@Service
@Slf4j
public class LinkInfoServiceImpl implements LinkInfoService {

    private static final Integer pageSize = 20;

    @Autowired
    private LinkInfoDao linkInfoDao;
    @Autowired
    private UserLinkCategoryDao userLinkCategoryDao;

    @Override
    public List<UserLinkInfoResp> getUserLinkInfo(Integer userId, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserLinkInfoResp> userLinkInfoRespList = linkInfoDao.selectUserLinkInfo(userId);
//        PageInfo<UserLinkInfoResp> page = new PageInfo<>(userLinkInfoRespList);
        return userLinkInfoRespList;
    }

    @Override
    public void removeLinkUrl(Integer id) {
        linkInfoDao.deleteLinkInfo(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void addLinkInfo(LinkInfoReq linkInfoReq) {
        //根据userId和分类id查询用户对应的分类表id，如果查不到，则插入一条用户分类表信息返回id信息
        Integer userLinkCategoryId;
        UserLinkCategory userLinkCategory = userLinkCategoryDao.selectByUserIdAndCategoryId(linkInfoReq.getUserId(), linkInfoReq.getLinkCategoryId());
        if (userLinkCategory == null) {
            userLinkCategory = new UserLinkCategory();
            userLinkCategory.setUserId(linkInfoReq.getUserId());
            userLinkCategory.setLinkCategoryId(linkInfoReq.getLinkCategoryId());
            userLinkCategory.setSortNo(999);
            userLinkCategoryDao.insertUserLinkCategory(userLinkCategory);
        }

        userLinkCategoryId = userLinkCategory.getId();

        LinkInfo linkInfo = new LinkInfo();
        linkInfo.setName(linkInfoReq.getName());
        linkInfo.setUrl(linkInfoReq.getUrl());
        linkInfo.setUserLinkCategoryId(userLinkCategoryId);
        linkInfo.setStatus(linkInfoReq.getStatus());
        linkInfo.setSortNo(linkInfoReq.getSortNo());

        linkInfoDao.insertLinkInfo(linkInfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Response modifyLinkInfo(User user, ModifyLinkInfoReq modifyLinkInfoReq) {
        UserLinkCategory userLinkCategory = userLinkCategoryDao.selectByUserIdAndCategoryId(user.getId(), modifyLinkInfoReq.getLinkCategoryId());
        Integer userLinkCategoryId = null;
        if (userLinkCategory == null) {
            userLinkCategory = new UserLinkCategory();
            userLinkCategory.setUserId(user.getId());
            userLinkCategory.setLinkCategoryId(modifyLinkInfoReq.getLinkCategoryId());
            userLinkCategory.setSortNo(999);
            userLinkCategoryDao.insertUserLinkCategory(userLinkCategory);
        }
        userLinkCategoryId = userLinkCategory.getId();

        LinkInfo linkInfo = new LinkInfo();
        linkInfo.setId(modifyLinkInfoReq.getId());
        linkInfo.setName(modifyLinkInfoReq.getName());
        linkInfo.setUrl(modifyLinkInfoReq.getUrl());
        linkInfo.setUserLinkCategoryId(userLinkCategoryId);
        linkInfo.setStatus(modifyLinkInfoReq.getStatus());
        linkInfo.setSortNo(modifyLinkInfoReq.getSortNo());

        userLinkCategoryDao.updateLinkInfoById(linkInfo);

        return Response.SUCCESS(CommonContent.UPDATE_SUCCESS);
    }

    @Override
    public List<LinkInfoExport> exportLinkInfo(Integer userId) {
        return linkInfoDao.selectAllLinkInfoForExport(userId);
    }
}
