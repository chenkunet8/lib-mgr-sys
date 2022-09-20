package com.ck.chenkunet.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {
    int id;
    String name;
    int teacherId;
    int roomId;
}
