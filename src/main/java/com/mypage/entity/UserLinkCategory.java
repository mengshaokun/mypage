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
public class UserLinkCategory implements Serializable{

    private Integer id;//id
    private Integer userId;//对应的用户id
    private Integer linkCategoryId;//对应的分类id
    private Integer sortNo;//排序号

}
