package com.ck.chenkunet.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomCourse {
    int id;
    int courseId;
    int roomId;
    String stime;
    String etime;
    String regular;
    String day;
    String time;

}
