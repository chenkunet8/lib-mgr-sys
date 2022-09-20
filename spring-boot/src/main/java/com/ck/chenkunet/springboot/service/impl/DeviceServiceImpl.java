package com.ck.chenkunet.springboot.service.impl;

import com.ck.chenkunet.springboot.entity.Device;
import com.ck.chenkunet.springboot.mapper.DeviceMapper;
import com.ck.chenkunet.springboot.service.IDeviceService;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl extends BaseServiceImpl<DeviceMapper, Device> implements IDeviceService {
}
