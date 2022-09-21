package com.ck.chenkunet.springboot.service;

import com.ck.chenkunet.springboot.entity.Room;

import java.util.List;

public interface IRoomService extends IBaseService<Room>{

    List<Room> selectByCourseId(int id);
}
