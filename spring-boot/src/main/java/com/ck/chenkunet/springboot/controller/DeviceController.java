package com.ck.chenkunet.springboot.controller;

import com.ck.chenkunet.springboot.entity.Device;
import com.ck.chenkunet.springboot.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/device")
public class DeviceController extends BaseController<IDeviceService, Device> {

    @Autowired
    IDeviceService service;
}
