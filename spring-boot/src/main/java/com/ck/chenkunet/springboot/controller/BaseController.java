package com.ck.chenkunet.springboot.controller;

import com.ck.chenkunet.springboot.pojo.Response;
import com.ck.chenkunet.springboot.service.IBaseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class BaseController<S extends IBaseService<T>, T> {

    @Autowired
    S service;

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
}
