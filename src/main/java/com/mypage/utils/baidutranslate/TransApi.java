package com.mypage.utils.baidutranslate;

import com.mypage.utils.SignUtils;

import java.util.HashMap;
import java.util.Map;

public class TransApi {

    private String host;
    private String appId;
    private String securityKey;

    public TransApi(String host, String appId, String securityKey) {
        this.host = host;
        this.appId = appId;
        this.securityKey = securityKey;
    }

    public String getTransResult(String query, String from, String to) {
        Map<String, String> params = buildParams(query, from, to);
        return HttpGet.get(host, params);
    }

    private Map<String, String> buildParams(String query, String from, String to) {
        Map<String, String> params = new HashMap<>();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);

        params.put("appid", appId);

        // 随机数
        String salt = String.valueOf(System.currentTimeMillis());
        params.put("salt", salt);

        // 签名
        String src = appId + query + salt + securityKey; // 加密前的原文
        params.put("sign", SignUtils.md5(src));

        return params;
    }

}
