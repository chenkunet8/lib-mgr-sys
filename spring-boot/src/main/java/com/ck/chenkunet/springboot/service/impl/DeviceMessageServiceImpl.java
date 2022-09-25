package com.ck.chenkunet.springboot.service.impl;

import com.ck.chenkunet.springboot.entity.DeviceMessage;
import com.ck.chenkunet.springboot.entity.DeviceMessageInfo;
import com.ck.chenkunet.springboot.mapper.DeviceMessageMapper;
import com.ck.chenkunet.springboot.service.IDeviceMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceMessageServiceImpl extends BaseServiceImpl<DeviceMessageMapper, DeviceMessage> implements IDeviceMessageService {

    @Autowired
    DeviceMessageMapper mapper;

    public List<DeviceMessageInfo> selectAllDeviceMessageInfo(){
        return mapper.selectAllDeviceMessageInfo();
    }

    public DeviceMessage selectOneByDeviceId(int deviceId){
        return mapper.selectOneByDeviceId(deviceId);
    }
}
