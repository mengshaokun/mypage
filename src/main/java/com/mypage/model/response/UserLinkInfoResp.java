package com.mypage.model.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by mengsk on 2019/5/31.
 *
 * 链接信息
 */
@Getter
@Setter
public class UserLinkInfoResp implements Serializable{

    private Integer id;
    private String name;
    private String url;//链接对应url
    private Integer userLinkCategoryId;//user_link_category表对应id
    private Integer status;
    private Integer sortNo;

    private Integer linkCategoryId;//分类信息id
    private String linkCategoryName;//分类信息名称

}
