package com.mypage.model.request;

import com.mypage.common.CommonContent;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by mengsk on 2019/6/14.
 */
@Getter
@Setter
public class LinkInfoReq {

    @NotNull(message = CommonContent.LINK_INFO_STATUS_NULL)
    private Integer userId;
    @NotBlank(message = CommonContent.LINK_INFO_NAME_NULL)
    private String name;
    @NotBlank(message = CommonContent.URL_NULL)
    private String url;
    @NotNull(message = CommonContent.LINK_CATEGORY_ID_NULL)
    private Integer linkCategoryId;//user_link_category表对应id
    @NotNull(message = CommonContent.LINK_INFO_STATUS_NULL)
    private Integer status;
    private Integer sortNo;


}
