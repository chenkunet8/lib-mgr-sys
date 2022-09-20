package com.ck.chenkunet.springboot.mapper;

import com.ck.chenkunet.springboot.entity.RoomCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoomCourseMapper extends BaseMapper<RoomCourse>{
    @Select("select * from lib_room_course")
    List<RoomCourse> selectAll();
}
