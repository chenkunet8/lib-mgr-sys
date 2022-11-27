package com.ck.chenkunet.springboot.auth.interceptor;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.ck.chenkunet.springboot.auth.annotation.IgnoreToken;
import com.ck.chenkunet.springboot.auth.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;
import java.lang.reflect.Method;

public class JwtInterceptor implements HandlerInterceptor {

    @Value("${spring.profiles.active}")
    private String profiles;

    @Autowired
    private TokenService tokenService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("application/json;charset=utf-8");
        //如果是开发环境，则不需要token。直接通过
        if (StringUtils.isEmpty(profiles) && profiles.equals("test")) {
            return true;
        }
        //如果接口或者类上有@IgnoreToken注解，意思该接口不需要token就能访问，需要放行
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        //先从类上获取该注解，判断类上是否加了IgnoreToken ，代表不需要token，直接放行
        IgnoreToken annotation = handlerMethod.getBeanType().getAnnotation(IgnoreToken.class);
        if (annotation == null) {
            //再从方法上获取该注解
            annotation = handlerMethod.getMethodAnnotation(IgnoreToken.class);
        }
        if (annotation != null) {
            return true;
        }
        String token = request.getHeader("X-Authorization");

        if (StringUtils.isEmpty(token)) {
            throw new ValidationException("token为空！");
        }
        DecodedJWT jwt = tokenService.checkToken(token);
        return jwt == null ? false : true;
    }
}
