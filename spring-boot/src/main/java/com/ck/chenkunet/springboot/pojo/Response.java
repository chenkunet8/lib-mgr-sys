package com.ck.chenkunet.springboot.pojo;

import io.netty.util.internal.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response<T> {
    /**
     * 状态码，200为正常
     */
    private String status;

    /**
     * 正常返回时的数据
     */
    private T data;

    /**
     * 非正常返回时的提醒数据
     */
    private String message;

    public static <T> Response<T> success(T data) {
        return new Response<>("200", data, "");
    }

    public static <T> Response<T> fail(String status, T data, String message) {
        return new Response<>(StringUtil.isNullOrEmpty(status) ? "900" : status, data, message);
    }

}
