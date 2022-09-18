package com.ck.chenkunet.springboot.mapper;

import java.util.List;

public interface BaseMapper<T> {

    List<T> selectAll();

    T selectOne(int id);

    int insert(T entity);

    int delete(int id);
}
