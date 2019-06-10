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

    public Response(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Response SUCCESS() {
        return new Response(200, "success", null);
    }

    public static Response SUCCESS(Object data) {
        return new Response(200, "success", data);
    }

    public static Response FAIL() {
        return new Response(100, "fail", null);
    }

    public static Response FAIL(Object data) {
        return new Response(100, "fail", data);
    }

    public static Response FAIL(Integer code, Object data) {
        return new Response(code, "fail", data);
    }

    public static boolean isSuccess(Response response) {
        return response.getCode() == 200;
    }
}
