package com.ck.chenkunet.springboot.mapper;

import com.ck.chenkunet.springboot.entity.User;

import java.util.List;

public interface BaseMapper<T> {

    List<T> selectAll();

    T selectOne(int id);

    int delete(int id);

    int login(User entity);

    int register(T entity);

    int updateById(T entity);

}
