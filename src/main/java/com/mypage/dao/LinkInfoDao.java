package com.mypage.dao;

import com.mypage.model.request.LinkInfoReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by mengsk on 2019/6/14.
 */
@Mapper
public interface LinkInfoDao {

    void insertLinkInfo(@Param("linkInfoReq") LinkInfoReq linkInfoReq);

    void updateLinkInfo(@Param("linkInfoReq") LinkInfoReq linkInfoReq);

}
