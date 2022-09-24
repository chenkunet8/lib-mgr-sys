package com.ck.chenkunet.springboot.service;

import com.ck.chenkunet.springboot.entity.Device;
import com.ck.chenkunet.springboot.entity.DeviceInfo;

import java.util.List;

public interface IDeviceService extends IBaseService<Device>{
    List<DeviceInfo> selectAllDeviceInfo();
}
