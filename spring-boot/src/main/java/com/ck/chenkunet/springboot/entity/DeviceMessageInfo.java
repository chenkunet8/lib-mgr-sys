package com.ck.chenkunet.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeviceMessageInfo {
    int id;
    String name;
    String type;
    String time;
    String comment;
    String phone;
    String s_name;
    String m_name;
}
