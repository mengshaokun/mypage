package com.mypage.model.request;

import lombok.Data;

/**
 * @author mengsk
 * @date 2020/5/29
 */
@Data
public class TranslateReq {

    private String query;//翻译的内容

    private String to;//翻译语言 zh en
}
