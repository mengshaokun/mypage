package com.mypage.service.serviceimpl;

import com.mypage.common.CommonContent;
import com.mypage.common.Response;
import com.mypage.dao.LinkInfoDao;
import com.mypage.model.request.LinkInfoReq;
import com.mypage.service.LinkInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mengsk on 2019/6/14.
 */
@Service
@Slf4j
public class LinkInfoServiceImpl implements LinkInfoService {

    @Autowired
    private LinkInfoDao linkInfoDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Response addLinkInfo(LinkInfoReq linkInfoReq) {
        try {
            linkInfoDao.insertLinkInfo(linkInfoReq);
        } catch (Exception e) {
            log.error(CommonContent.ADD_LINK_INFO_ERROR + ": " + e);
            return Response.FAIL(CommonContent.ADD_LINK_INFO_ERROR);
        }

        return Response.SUCCESS();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Response modifyLinkInfo(LinkInfoReq linkInfoReq) {
        try {
            linkInfoDao.updateLinkInfo(linkInfoReq);
        } catch (Exception e) {
            log.error(CommonContent.MODIFY_LINK_INFO_ERROR + ": " + e);
            return Response.FAIL(CommonContent.MODIFY_LINK_INFO_ERROR);
        }

        return Response.SUCCESS();
    }


}
