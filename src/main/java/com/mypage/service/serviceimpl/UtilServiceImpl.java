package com.mypage.service.serviceimpl;

import com.mypage.dao.UtilDao;
import com.mypage.entity.CodeLibrary;
import com.mypage.entity.LinkCategory;
import com.mypage.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mengsk on 2019/7/26.
 */
@Service
public class UtilServiceImpl implements UtilService {

    @Autowired
    private UtilDao utilDao;

    @Override
    public List<LinkCategory> getLinkCategoryList() {
        return utilDao.selectLinkCategoryList();
    }

    @Override
    public List<CodeLibrary> getCodeLibraryByCodeNo(String codeNo) {
        return utilDao.selectCodeLibraryByCodeNo(codeNo);
    }
}
