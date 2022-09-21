package com.ck.chenkunet.springboot.service.impl;

import com.ck.chenkunet.springboot.entity.Room;
import com.ck.chenkunet.springboot.mapper.RoomMapper;
import com.ck.chenkunet.springboot.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl extends BaseServiceImpl<RoomMapper, Room> implements IRoomService {

    @Autowired
    protected RoomMapper mapper;

    public List<Room> selectByCourseId(int id) {
        return mapper.selectByCourseId(id);
    }
}
