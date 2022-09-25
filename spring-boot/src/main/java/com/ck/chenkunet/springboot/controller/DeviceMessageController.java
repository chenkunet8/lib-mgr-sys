package com.ck.chenkunet.springboot.controller;

import com.ck.chenkunet.springboot.entity.DeviceMessage;
import com.ck.chenkunet.springboot.entity.DeviceMessageInfo;
import com.ck.chenkunet.springboot.pojo.Response;
import com.ck.chenkunet.springboot.service.IDeviceMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/device-message")
public class DeviceMessageController extends BaseController<IDeviceMessageService, DeviceMessage> {

    @Autowired
    IDeviceMessageService service;

    @ResponseBody
    @GetMapping("/selectAllDeviceMessageInfo")
    public Response<List<DeviceMessageInfo>> selectAllDeviceMessageInfo() {
        try {
            List<DeviceMessageInfo> list = service.selectAllDeviceMessageInfo();
            System.out.println(list);
            return Response.success(list);
        } catch (Exception e) {
            return Response.fail("", null, e.getMessage());
        }
    }

    @ResponseBody
    @GetMapping("/selectOneByDeviceId")
    public Response<DeviceMessage> selectOneByDeviceId(int deviceId) {
        try {
            DeviceMessage list = service.selectOneByDeviceId(deviceId);
            System.out.println(list);
            return Response.success(list);
        } catch (Exception e) {
            return Response.fail("", null, e.getMessage());
        }
    }
}
