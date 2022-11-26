package com.ck.chenkunet.springboot.service;

import com.ck.chenkunet.springboot.entity.User;

import java.util.List;

public interface IBaseService<T> {
    List<T> selectAll();
    T selectOne(int id);
    int login(User user);
    int register(T entity);
    int updateById(T entity);
}
