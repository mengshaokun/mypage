package com.mypage.service;

import com.mypage.common.Response;
import com.mypage.model.request.LinkInfoReq;
import com.mypage.model.response.UserLinkInfoResp;

import java.util.List;

/**
 * Created by mengsk on 2019/6/14.
 */
public interface LinkInfoService {
    List<UserLinkInfoResp> getUserLinkInfo(Integer userId);

    void removeLinkUrl(Integer id);
}
