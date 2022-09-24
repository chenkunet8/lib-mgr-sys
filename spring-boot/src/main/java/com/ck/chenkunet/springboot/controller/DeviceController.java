package com.ck.chenkunet.springboot.controller;

import com.ck.chenkunet.springboot.entity.Device;
import com.ck.chenkunet.springboot.entity.DeviceInfo;
import com.ck.chenkunet.springboot.pojo.Response;
import com.ck.chenkunet.springboot.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/device")
public class DeviceController extends BaseController<IDeviceService, Device> {

    @Autowired
    IDeviceService service;

    @ResponseBody
    @GetMapping("/selectAllDeviceInfo")
    public Response<List<DeviceInfo>> selectAllDeviceInfo() {
        try {
            List<DeviceInfo> list = service.selectAllDeviceInfo();
            return Response.success(list);
        } catch (Exception e) {
            return Response.fail("", null, e.getMessage());
        }
    }
}
