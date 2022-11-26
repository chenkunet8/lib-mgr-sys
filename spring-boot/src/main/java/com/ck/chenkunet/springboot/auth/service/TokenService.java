package com.ck.chenkunet.springboot.auth.service;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.ck.chenkunet.springboot.entity.User;

public interface TokenService {

    //获取token
    String getToken(User user);

    //判断token是否可用
    DecodedJWT checkToken(String token, String phone);

}
