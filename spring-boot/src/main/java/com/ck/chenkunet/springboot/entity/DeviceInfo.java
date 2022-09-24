package com.ck.chenkunet.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeviceInfo {
    int id;
    String type;
    String owner;
    int user;
    String time;
    String status;
    String name;
    String model;
    String phone;
    String s_name;
}
