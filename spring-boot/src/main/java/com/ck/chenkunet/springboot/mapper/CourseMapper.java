package com.ck.chenkunet.springboot.mapper;

import com.ck.chenkunet.springboot.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseMapper extends BaseMapper<Course>{
    @Select("select * from lib_course")
    List<Course> selectAll();

    @Select("select * from lib_course where id = #{id}")
    Course selectOne();
}
