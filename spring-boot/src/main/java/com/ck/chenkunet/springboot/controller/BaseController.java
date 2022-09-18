package com.ck.chenkunet.springboot.controller;

import com.ck.chenkunet.springboot.pojo.Response;
import com.ck.chenkunet.springboot.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class BaseController<S extends IBaseService<T>,T> {

    @Autowired
    S service;

    @ResponseBody
    @GetMapping("/selectAll")
    public Response<List<T>> selectAll() {
        try {
            List<T> list = service.selectAll();
            return Response.success(list);
        } catch (Exception e) {
            return Response.fail("", null, "error");
        }
    }
}
