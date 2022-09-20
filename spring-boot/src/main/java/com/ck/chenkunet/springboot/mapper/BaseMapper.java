package com.ck.chenkunet.springboot.mapper;

import java.util.List;

public interface BaseMapper<T> {

    List<T> selectAll();

    T selectOne(int id);

    int delete(int id);

    int login(T entity);

    int register(T entity);

}
