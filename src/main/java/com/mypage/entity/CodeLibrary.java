package com.mypage.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by mengsk on 2019/7/26.
 */
@Getter
@Setter
public class CodeLibrary implements Serializable {

    private Integer id;
    private String codeNo;
    private String itemNo;
    private String itemName;
    private Integer sortNo;

}
