package com.mypage.common;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by MSK on 2019/6/1.
 * 通用返回数据格式
 */
@Getter
@Setter
public class Response {

    private Integer code;
    private String message;
    private Object data;

    public static Response SUCCESS() {
        Response response = new Response();
        response.setCode(200);
        response.setMessage("success");
        return response;
    }

    public static Response SUCCESS(Object data) {
        Response response = new Response();
        response.setCode(200);
        response.setMessage("success");
        response.setData(data);
        return response;
    }

    public static Response FAIL() {
        Response response = new Response();
        response.setCode(100);
        response.setMessage("fail");
        return response;
    }

    public static Response FAIL(Object data) {
        Response response = new Response();
        response.setCode(100);
        response.setMessage("fail");
        response.setData(data);
        return response;
    }

    public static Response FAIL(Integer code, Object data) {
        Response response = new Response();
        response.setCode(code);
        response.setMessage("fail");
        response.setData(data);
        return response;
    }

    public static boolean isSuccess(Response response) {
        return response.getCode() == 200;
    }
}
