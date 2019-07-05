package com.mypage.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mengsk on 2019/5/31.
 *
 * 用户链接类别
 */
@Getter
@Setter
public class LinkCategory implements Serializable{

    private Integer id;//id
    private String name;//分类名称
    private List<LinkInfo> linkInfoList;//分类下对应的链接信息

}
