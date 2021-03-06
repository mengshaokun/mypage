package com.mypage.dao;

import com.mypage.entity.LinkInfo;
import com.mypage.entity.LinkInfoExport;
import com.mypage.model.response.UserLinkInfoResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by mengsk on 2019/6/14.
 */
@Mapper
public interface LinkInfoDao {
    List<UserLinkInfoResp> selectUserLinkInfo(@Param("userId") Integer userId);

    void deleteLinkInfo(@Param("id") Integer id);

    void insertLinkInfo(@Param("linkInfo") LinkInfo linkInfo);

    List<LinkInfoExport> selectAllLinkInfoForExport(@Param("userId") Integer userId);

    void updateLinkInfo(@Param("linkInfo") LinkInfo linkInfo);
}
