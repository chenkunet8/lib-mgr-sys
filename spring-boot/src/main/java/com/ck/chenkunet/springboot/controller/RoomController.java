package com.ck.chenkunet.springboot.controller;

import com.ck.chenkunet.springboot.entity.Room;
import com.ck.chenkunet.springboot.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/room")
public class RoomController extends BaseController<IRoomService, Room> {

    @Autowired
    IRoomService service;
}
