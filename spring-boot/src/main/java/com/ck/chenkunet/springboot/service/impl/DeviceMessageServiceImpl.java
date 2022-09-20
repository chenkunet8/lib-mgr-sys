package com.ck.chenkunet.springboot.service.impl;

import com.ck.chenkunet.springboot.entity.DeviceMessage;
import com.ck.chenkunet.springboot.mapper.DeviceMessageMapper;
import com.ck.chenkunet.springboot.service.IDeviceMessageService;
import org.springframework.stereotype.Service;

@Service
public class DeviceMessageServiceImpl extends BaseServiceImpl<DeviceMessageMapper, DeviceMessage> implements IDeviceMessageService {
}
