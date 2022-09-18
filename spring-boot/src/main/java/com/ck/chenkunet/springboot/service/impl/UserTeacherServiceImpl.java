package com.ck.chenkunet.springboot.service.impl;

import com.ck.chenkunet.springboot.entity.UserStudent;
import com.ck.chenkunet.springboot.entity.UserTeacher;
import com.ck.chenkunet.springboot.mapper.UserStudentMapper;
import com.ck.chenkunet.springboot.mapper.UserTeacherMapper;
import com.ck.chenkunet.springboot.service.IUserStudentService;
import com.ck.chenkunet.springboot.service.IUserTeacherService;
import org.springframework.stereotype.Service;

@Service
public class UserTeacherServiceImpl extends BaseServiceImpl<UserTeacherMapper, UserTeacher> implements IUserTeacherService {
}
