package com.mypage.utils;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * @author mengsk
 * @date 2020/5/27
 */
@Component
@Slf4j
public class HttpClientUtils {

    private static final Integer TIMEOUT = 5000;
    private static final String CHARSET = "UTF-8";

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
            log.error("调用接口失败==>接口：{}, 参数：{}", url, getParamJson(params));
            return null;
        }
        return responseEntity.getBody();
    }


    /**
     * 有参数的get请求
     * @param url
     * @param params
     * @return
     */
    public static String doGet(String url, Map<String, String> params) {
        String result = null;
        org.apache.http.HttpEntity entity = null;

        try {
            url = getUrl(url, params);
            HttpClient httpClient = HttpClientBuilder.create().build();
            URI uri = new URI(url);
            HttpGet httpGet = new HttpGet(uri);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(TIMEOUT).setSocketTimeout(TIMEOUT).build();
            httpGet.setConfig(requestConfig);

            HttpResponse execute = httpClient.execute(httpGet);

            entity = execute.getEntity();

            if (entity != null) {
                result = EntityUtils.toString(entity, CHARSET);
            }
        } catch (Exception e) {
            log.error("GET请求，调用接口失败==>接口：{}, 参数：{}", url, getParamJson(params));
        } finally {
            if (entity != null) {
                EntityUtils.consumeQuietly(entity);
            }
        }

        return result;
    }


    /**
     * GET请求，拼接参数
     * @param url
     * @param params
     * @return
     */
    public static String getUrl(String url, Map<String, String> params) {
        if (params == null) {
            return url;
        }

        StringBuilder builder = new StringBuilder(url);
        if (url.contains("?")) {
            builder.append("&");
        } else {
            builder.append("?");
        }

        int i = 0;
        for (String key : params.keySet()) {
            String value = params.get(key);
            if (value == null) { // 过滤空的key
                continue;
            }

            if (i != 0) {
                builder.append('&');
            }

            builder.append(key);
            builder.append('=');
            builder.append(value);

            i++;
        }

        return builder.toString();
    }

    private static String getParamJson(Object param) {
        return param == null ? "" : JSON.toJSONString(param);
    }
}
