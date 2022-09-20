package com.ck.chenkunet.springboot.service.impl;

import com.ck.chenkunet.springboot.entity.DeviceType;
import com.ck.chenkunet.springboot.mapper.DeviceTypeMapper;
import com.ck.chenkunet.springboot.service.IDeviceTypeService;
import org.springframework.stereotype.Service;

@Service
public class DeviceTypeServiceImpl extends BaseServiceImpl<DeviceTypeMapper, DeviceType> implements IDeviceTypeService {
}
