package com.ck.chenkunet.springboot.service;

import com.ck.chenkunet.springboot.entity.DeviceMessage;
import com.ck.chenkunet.springboot.entity.DeviceMessageInfo;

import java.util.List;

public interface IDeviceMessageService extends IBaseService<DeviceMessage>{
    List<DeviceMessageInfo> selectAllDeviceMessageInfo();

    DeviceMessage selectOneByDeviceId(int deviceId);
}
