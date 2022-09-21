package com.ck.chenkunet.springboot.controller;

import com.ck.chenkunet.springboot.entity.Room;
import com.ck.chenkunet.springboot.pojo.Response;
import com.ck.chenkunet.springboot.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/room")
public class RoomController extends BaseController<IRoomService, Room> {

    @Autowired
    IRoomService service;

    @ResponseBody
    @GetMapping("/selectByCourseId")
    public Response updateById(int id) {
        try {
            List<Room> entity = service.selectByCourseId(id);
            return Response.success(entity);
        } catch (Exception e) {
            return Response.fail("", null, e.getMessage());
        }
    }
}
