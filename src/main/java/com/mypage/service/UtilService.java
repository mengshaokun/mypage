package com.mypage.service;

import com.mypage.common.Response;
import com.mypage.entity.CodeLibrary;
import com.mypage.entity.LinkCategory;
import com.mypage.entity.User;
import com.mypage.model.request.UserInfoReq;

import java.util.List;

/**
 * Created by mengsk on 2019/7/26.
 */
public interface UtilService {

    List<LinkCategory> getLinkCategoryList();

    List<CodeLibrary> getCodeLibraryByCodeNo(String codeNo);
}
