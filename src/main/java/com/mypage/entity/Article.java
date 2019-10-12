package com.mypage.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by mengsk on 2019/10/11.
 */
@Getter
@Setter
public class Article {

    private Integer id;
    private String title;
    private String describe;
    private String content;
    private Integer author;
    private Date insertTime;
    private Date updateTime;

}
