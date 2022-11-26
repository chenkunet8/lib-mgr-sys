package com.ck.chenkunet.springboot.auth.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ck.chenkunet.springboot.auth.service.TokenService;
import com.ck.chenkunet.springboot.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class ToeknServiceImpl implements TokenService {

    @Value("token.secret")
    String SECRET;

    @Override
    public String getToken(User user) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MINUTE,1);//设置过期时间

        JWTCreator.Builder builder = JWT.create();//插入用户数据
        builder.withClaim("phone",user.getPhone());
        builder.withClaim("name",user.getName());
        String token = builder.withExpiresAt(instance.getTime()).sign(Algorithm.HMAC256(SECRET));
        return token;
    }

    @Override
    public DecodedJWT checkToken(String token, String phone) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        try {
            JWTVerifier jwtVerifier = JWT.require(algorithm).withClaim("phone", phone).build();
            return jwtVerifier.verify(token);
        }catch (SignatureVerificationException e) {
            //验证的签名不一致
            throw new SignatureVerificationException(algorithm);
        }catch (TokenExpiredException e){
            throw new TokenExpiredException("token已超时");
        }catch (AlgorithmMismatchException e){
            throw new AlgorithmMismatchException("签名算法不匹配");
        }catch (InvalidClaimException e){
            throw new InvalidClaimException("校验的claims内容不匹配");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
