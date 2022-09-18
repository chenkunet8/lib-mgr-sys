package com.ck.chenkunet.springboot.controller;

import com.ck.chenkunet.springboot.entity.UserManager;
import com.ck.chenkunet.springboot.mapper.UserManagerMapper;
import com.ck.chenkunet.springboot.pojo.Response;
import com.ck.chenkunet.springboot.service.IUserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user-manager")
public class UserMangerController {

    @Autowired
    IUserManagerService service;

    @ResponseBody
    @GetMapping("/select")
    public Response<UserManager> getAll() {
        try {
            UserManager entity = service.selectAll();
            return Response.success(entity);
        } catch (Exception e) {
            return Response.fail("", null, "error");
        }
    }
}
