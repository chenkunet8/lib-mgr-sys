package com.ck.chenkunet.springboot.service.impl;

import com.ck.chenkunet.springboot.entity.UserManager;
import com.ck.chenkunet.springboot.mapper.UserManagerMapper;
import com.ck.chenkunet.springboot.service.IUserManagerService;
import org.springframework.stereotype.Service;

@Service
public class UserManagerServiceImpl extends BaseServiceImpl<UserManagerMapper, UserManager> implements IUserManagerService {
}
