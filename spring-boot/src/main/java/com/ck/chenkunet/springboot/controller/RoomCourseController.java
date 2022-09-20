package com.ck.chenkunet.springboot.controller;

import com.ck.chenkunet.springboot.entity.Course;
import com.ck.chenkunet.springboot.entity.RoomCourse;
import com.ck.chenkunet.springboot.service.ICourseService;
import com.ck.chenkunet.springboot.service.IRoomCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/room-course")
public class RoomCourseController extends BaseController<IRoomCourseService, RoomCourse> {

    @Autowired
    IRoomCourseService service;
}
