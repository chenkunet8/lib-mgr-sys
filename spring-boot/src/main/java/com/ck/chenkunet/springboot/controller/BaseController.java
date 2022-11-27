package com.ck.chenkunet.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ck.chenkunet.springboot.auth.annotation.IgnoreToken;
import com.ck.chenkunet.springboot.auth.service.TokenService;
import com.ck.chenkunet.springboot.entity.User;
import com.ck.chenkunet.springboot.pojo.Response;
import com.ck.chenkunet.springboot.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class BaseController<S extends IBaseService<T>, T> {

    @Autowired
    S service;

    @Autowired
    TokenService tokenService;

    @ResponseBody
    @GetMapping("/selectAll")
    public Response<List<T>> selectAll() {
        try {
            List<T> list = service.selectAll();
            return Response.success(list);
        } catch (Exception e) {
            return Response.fail("", null, e.getMessage());
        }
    }

    @ResponseBody
    @GetMapping("/selectOne")
    public Response<T> selectOne(int id) {
        try {
            T entity = service.selectOne(id);
            return Response.success(entity);
        } catch (Exception e) {
            return Response.fail("", null, e.getMessage());
        }
    }

    @ResponseBody
    @PostMapping("/login")
    @IgnoreToken
    public Response login(@RequestBody User entity) {
        try {
            service.login(entity);
            String token = tokenService.getToken(entity);
            return Response.success(token);
        } catch (Exception e) {
            return Response.fail("", null, e.getMessage());
        }
    }

    @ResponseBody
    @PostMapping("/register")
    public Response register(@RequestBody T entity) {
        try {
            int id = service.register(entity);
            return Response.success(id);
        } catch (Exception e) {
            return Response.fail("", null, e.getMessage());
        }
    }

    @ResponseBody
    @PostMapping("/updateById")
    public Response updateById(@RequestBody T entity) {
        try {
            int id = service.updateById(entity);
            return Response.success(id);
        } catch (Exception e) {
            return Response.fail("", null, e.getMessage());
        }
    }
}
