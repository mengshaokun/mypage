package com.mypage.service;

import com.mypage.common.Response;
import com.mypage.model.request.LinkInfoReq;

/**
 * Created by mengsk on 2019/6/14.
 */
public interface LinkInfoService {

    Response addLinkInfo(LinkInfoReq linkInfoReq);

    Response modifyLinkInfo(LinkInfoReq linkInfoReq);
}
