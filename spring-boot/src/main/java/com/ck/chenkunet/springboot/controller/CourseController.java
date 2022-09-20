package com.ck.chenkunet.springboot.controller;

import com.ck.chenkunet.springboot.entity.Course;
import com.ck.chenkunet.springboot.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/course")
public class CourseController extends BaseController<ICourseService, Course> {

    @Autowired
    ICourseService service;
}
