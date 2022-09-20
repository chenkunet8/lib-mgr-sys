package com.ck.chenkunet.springboot.mapper;

import com.ck.chenkunet.springboot.entity.UserTeacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserTeacherMapper extends BaseMapper<UserTeacher>{
    @Select("select * from lib_user_teacher")
    List<UserTeacher> selectAll();

    @Select("select id from lib_user_teacher where phone=#{phone} and pwd=#{pwd}")
    int login(UserTeacher entity);
}
