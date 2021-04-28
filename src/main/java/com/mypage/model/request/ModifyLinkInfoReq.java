package com.mypage.model.request;

import com.mypage.common.CommonContent;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by MSK on 2020/6/7.
 */
@Data
public class ModifyLinkInfoReq {

    @NotNull(message = CommonContent.LINK_INFO_ID_NULL)
    private Integer id;
    @NotBlank(message = CommonContent.LINK_INFO_NAME_NULL)
    private String name;
    @NotBlank(message = CommonContent.URL_NULL)
    private String url;
    @NotNull(message = CommonContent.LINK_CATEGORY_ID_NULL)
    private Integer linkCategoryId;//
    @NotNull(message = CommonContent.LINK_INFO_STATUS_NULL)
    private Integer status;
    private Integer sortNo;
}
