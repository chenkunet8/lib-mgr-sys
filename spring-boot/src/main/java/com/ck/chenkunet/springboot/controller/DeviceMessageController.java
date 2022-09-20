package com.ck.chenkunet.springboot.controller;

import com.ck.chenkunet.springboot.entity.DeviceMessage;
import com.ck.chenkunet.springboot.service.IDeviceMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/device-message")
public class DeviceMessageController extends BaseController<IDeviceMessageService, DeviceMessage> {

    @Autowired
    IDeviceMessageService service;
}
