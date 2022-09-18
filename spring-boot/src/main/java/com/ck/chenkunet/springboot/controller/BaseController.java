package com.ck.chenkunet.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api")
public class BaseController {

    @ResponseBody
    @GetMapping("/test")
    public String test() {
        return "Hello World";
    }
}
