package com.ck.chenkunet.springboot.controller;


import com.ck.chenkunet.springboot.entity.UserStudent;
import com.ck.chenkunet.springboot.service.IUserStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user-student")
public class UserStudentController extends BaseController<IUserStudentService, UserStudent>{

    @Autowired
    IUserStudentService service;
}
