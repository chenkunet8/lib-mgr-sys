package com.ck.chenkunet.springboot.mapper;

import com.ck.chenkunet.springboot.entity.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoomMapper extends BaseMapper<Room>{
    @Select("select * from lib_room")
    List<Room> selectAll();
}
