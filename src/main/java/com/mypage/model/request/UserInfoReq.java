package com.mypage.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * Created by MSK on 2019/6/1.
 */
@Getter
@Setter
public class UserInfoReq {

    private String name;
    @NotBlank(message = "昵称不能为空！")
    private String nickName;
    @NotBlank(message = "密码不能为空！")
    private String password;
    private String code;

}
