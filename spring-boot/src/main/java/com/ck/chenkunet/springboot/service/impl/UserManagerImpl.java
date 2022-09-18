package com.ck.chenkunet.springboot.service.impl;

import com.ck.chenkunet.springboot.entity.UserManager;
import com.ck.chenkunet.springboot.mapper.UserManagerMapper;
import com.ck.chenkunet.springboot.service.IUserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagerImpl implements IUserManagerService {

    @Autowired
    UserManagerMapper mapper;

    @Override
    public UserManager selectAll() {
        return mapper.selectAll();
    }
}
