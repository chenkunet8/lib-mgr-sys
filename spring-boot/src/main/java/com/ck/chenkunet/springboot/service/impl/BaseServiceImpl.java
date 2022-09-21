package com.ck.chenkunet.springboot.service.impl;

import com.ck.chenkunet.springboot.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseServiceImpl<M extends BaseMapper<T>, T> {

    @Autowired
    protected M mapper;

    public List<T> selectAll() {
        return mapper.selectAll();
    }

    public T selectOne(int id) {
        return mapper.selectOne(id);
    }

    public int login(T entity) {
        return mapper.login(entity);
    }

    public int register(T entity) {
        return mapper.register(entity);
    }

    public int updateById(T entity) {
        return mapper.updateById(entity);
    }
}
