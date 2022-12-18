package com.ck.chenkunet.springboot.cv;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class HttpUtil {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * 通用发送post请求
     * @param url
     * @param content
     * @return
     */
    public static JSONObject doPost(String url, String content) {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .readTimeout(3, TimeUnit.SECONDS)
                    .writeTimeout(3, TimeUnit.SECONDS)
                    .connectTimeout(3, TimeUnit.SECONDS).build();
            RequestBody body = RequestBody.create(JSON, content);
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            return JSONObject.parseObject(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONObject();
    }
}
