package com.mypage.dao;

import com.mypage.entity.CodeLibrary;
import com.mypage.entity.LinkCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by mengsk on 2019/7/26.
 */
public interface UtilDao {

    List<LinkCategory> selectLinkCategoryList();

    List<CodeLibrary> selectCodeLibraryByCodeNo(@Param("codeNo") String codeNo);
}
