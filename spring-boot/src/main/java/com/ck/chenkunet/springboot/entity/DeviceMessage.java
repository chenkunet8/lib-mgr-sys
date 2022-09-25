package com.ck.chenkunet.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeviceMessage {
    int id;
    int deviceId;
    String type;
    String time;
    int managerId;
    int userId;
    String comment;
}
