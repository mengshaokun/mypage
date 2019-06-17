package com.mypage.model.request;

import com.mypage.common.CommonContent;
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
    @NotBlank(message = CommonContent.NICK_NAME_NULL)
    private String nickName;
    @NotBlank(message = CommonContent.PASSWORD_NULL)
    private String password;
    private String code;

}
