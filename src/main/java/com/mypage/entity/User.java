package com.mypage.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by MSK on 2019/5/27.
 */
@Getter
@Setter
public class User implements Serializable{

    private Integer id;
    private String name;
    private String nickName;
    private Integer status;
    private String password;

}
