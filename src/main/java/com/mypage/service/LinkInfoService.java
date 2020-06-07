package com.mypage.service;

import com.mypage.common.Response;
import com.mypage.entity.LinkInfoExport;
import com.mypage.entity.User;
import com.mypage.model.request.LinkInfoReq;
import com.mypage.model.request.ModifyLinkInfoReq;
import com.mypage.model.response.UserLinkInfoResp;

import java.util.List;

/**
 * Created by mengsk on 2019/6/14.
 */
public interface LinkInfoService {
    List<UserLinkInfoResp> getUserLinkInfo(Integer userId, Integer pageNum);

    void removeLinkUrl(Integer id);

    void addLinkInfo(LinkInfoReq linkInfoReq);

    List<LinkInfoExport> exportLinkInfo(Integer userId);

    Response modifyLinkInfo(User user, ModifyLinkInfoReq modifyLinkInfoReq);
}
