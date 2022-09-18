package com.ck.chenkunet.springboot.controller;

import com.ck.chenkunet.springboot.entity.UserManager;
import com.ck.chenkunet.springboot.service.IUserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user-manager")
public class UserMangerController extends BaseController<IUserManagerService, UserManager> {

    @Autowired
    IUserManagerService service;
}
