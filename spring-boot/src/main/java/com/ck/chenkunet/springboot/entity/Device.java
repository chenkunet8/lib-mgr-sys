package com.ck.chenkunet.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Device {
    int id;
    int type;
    String owner;
    int user;
    String time;
    String status;
    String name;
    String model;
}
