package com.ck.chenkunet.springboot.service.impl;

import com.ck.chenkunet.springboot.entity.Course;
import com.ck.chenkunet.springboot.mapper.CourseMapper;
import com.ck.chenkunet.springboot.service.ICourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends BaseServiceImpl<CourseMapper, Course> implements ICourseService {
}
