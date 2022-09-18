package com.ck.chenkunet.springboot.service.impl;

import com.ck.chenkunet.springboot.entity.UserStudent;
import com.ck.chenkunet.springboot.mapper.UserStudentMapper;
import com.ck.chenkunet.springboot.service.IUserStudentService;
import org.springframework.stereotype.Service;

@Service
public class UserStudentServiceImpl extends BaseServiceImpl<UserStudentMapper, UserStudent> implements IUserStudentService {
}
