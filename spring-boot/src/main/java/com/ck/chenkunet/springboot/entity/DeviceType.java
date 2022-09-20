package com.ck.chenkunet.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeviceType {
    int id;
    String name;
    String comment;
    int num;
}
