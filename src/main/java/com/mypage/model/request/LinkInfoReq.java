package com.mypage.model.request;

import com.mypage.common.CommonContent;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * Created by mengsk on 2019/6/14.
 */
@Getter
@Setter
public class LinkInfoReq {

    private Integer id;
    @NotBlank(message = CommonContent.LINK_INFO_NAME_NULL)
    private String name;
    @NotBlank(message = CommonContent.URL_NULL)
    private String url;
    @NotBlank(message = CommonContent.USER_LINK_CATEGORY_ID_NULL)
    private Integer userLinkCategoryId;//user_link_category表对应id
    private Integer status;
    private Integer sortNo;


}
