package com.mypage.service.serviceimpl;

import com.mypage.dao.LinkInfoDao;
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

    @Override
    public List<UserLinkInfoResp> getUserLinkInfo(Integer userId) {
        return linkInfoDao.selectUserLinkInfo(userId);
    }

    @Override
    public void removeLinkUrl(Integer id) {
        linkInfoDao.deleteLinkInfo(id);
    }
}
