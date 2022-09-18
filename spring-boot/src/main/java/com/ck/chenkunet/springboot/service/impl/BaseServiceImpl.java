package com.ck.chenkunet.springboot.service.impl;

import com.ck.chenkunet.springboot.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class BaseServiceImpl<M extends BaseMapper<T>, T> {

    @Autowired
    protected M mapper;

    public List<T> selectAll() {
        return  mapper.selectAll();
    }
}
