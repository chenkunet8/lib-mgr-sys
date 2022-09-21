package com.ck.chenkunet.springboot.mapper;

import com.ck.chenkunet.springboot.entity.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoomMapper extends BaseMapper<Room> {
    @Select("select * from lib_room")
    List<Room> selectAll();

    /**
     * 查询某个课程的教室信息
     *
     * @param id 课程id
     * @return
     */
    @Select({"<script>"
            + " select * from lib_room where id in "
            + " (SELECT  "
            + " SUBSTRING_INDEX(SUBSTRING_INDEX(a.room_id,&apos;,&apos;,b.help_topic_id+1),&apos;,&apos;,-1) AS num "
            + " FROM "
            + " lib_course a "
            + " join mysql.help_topic b "
            + " on"
            + " b.help_topic_id &lt; LENGTH(a.room_id)-LENGTH(REPLACE(a.room_id,&apos;,&apos;,&apos;&apos;))+1 "
            + " where a.id=#{id}) "
            + "</script>"})
    List<Room> selectByCourseId(int id);
}
