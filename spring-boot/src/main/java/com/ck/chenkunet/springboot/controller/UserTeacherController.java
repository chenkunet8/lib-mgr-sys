package com.ck.chenkunet.springboot.controller;


import com.ck.chenkunet.springboot.entity.UserTeacher;
import com.ck.chenkunet.springboot.service.IUserTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user-teacher")
public class UserTeacherController extends BaseController<IUserTeacherService, UserTeacher>{

    @Autowired
    IUserTeacherService service;
}
