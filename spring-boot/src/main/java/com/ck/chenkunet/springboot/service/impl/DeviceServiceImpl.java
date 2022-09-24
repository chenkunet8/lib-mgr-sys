package com.ck.chenkunet.springboot.service.impl;

import com.ck.chenkunet.springboot.entity.Device;
import com.ck.chenkunet.springboot.entity.DeviceInfo;
import com.ck.chenkunet.springboot.mapper.DeviceMapper;
import com.ck.chenkunet.springboot.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl extends BaseServiceImpl<DeviceMapper, Device> implements IDeviceService {

    @Autowired
    protected DeviceMapper mapper;

    public List<DeviceInfo> selectAllDeviceInfo(){
        return mapper.selectAllDeviceInfo();
    }
}
