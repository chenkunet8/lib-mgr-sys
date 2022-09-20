package com.ck.chenkunet.springboot.controller;

import com.ck.chenkunet.springboot.entity.DeviceType;
import com.ck.chenkunet.springboot.service.IDeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/device-type")
public class DeviceTypeController extends BaseController<IDeviceTypeService, DeviceType> {

    @Autowired
    IDeviceTypeService service;
}
