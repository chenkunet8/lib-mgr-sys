package com.ck.chenkunet.springboot.service;

import java.util.List;

public interface IBaseService<T> {
    List<T> selectAll();
}
