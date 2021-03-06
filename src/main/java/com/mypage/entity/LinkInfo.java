package com.mypage.entity;

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
public class LinkInfo implements Serializable{

    private Integer id;
    private String name;
    private String url;//链接对应url
    private Integer userLinkCategoryId;//user_link_category表对应id
    private Integer status;
    private Integer sortNo;

}
