package com.mypage.utils;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Exchanger;

/**
 * @author mengsk
 * @date 2020/5/27
 */
@Component
@Slf4j
public class HttpUtils {

    @Resource
    private RestTemplate restTemplate;

    public String get(String url, Map<String, String> params) {
        HttpEntity<MultiValueMap<String, String>> httpEntity = null;
        if (params != null) {
            MultiValueMap<String, String> paramMap = new LinkedMultiValueMap();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                paramMap.add(entry.getKey(), entry.getValue());
            }
            httpEntity = new HttpEntity<>(paramMap);
        }
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            log.error("调用接口失败==>接口：{}, 参数：{}", url, JSON.toJSONString(params));
            return null;
        }
        return responseEntity.getBody();
    }


}
