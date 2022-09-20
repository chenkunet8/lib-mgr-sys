package com.ck.chenkunet.springboot.service.impl;

import com.ck.chenkunet.springboot.entity.Room;
import com.ck.chenkunet.springboot.mapper.RoomMapper;
import com.ck.chenkunet.springboot.service.IRoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl extends BaseServiceImpl<RoomMapper, Room> implements IRoomService {
}
