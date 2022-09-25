package com.ck.chenkunet.springboot.mapper;

import com.ck.chenkunet.springboot.entity.UserManager;
import com.ck.chenkunet.springboot.entity.UserStudent;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserStudentMapper extends BaseMapper<UserStudent> {
    @Select("select * from lib_user_student")
    List<UserStudent> selectAll();

    @Select("select id from lib_user_student where phone=#{phone} and pwd=#{pwd}")
    int login(UserStudent entity);

    @Insert("insert into lib_user_student (name,pwd,phone,sid,academy) values (#{name},#{pwd},#{phone},#{sid},#{academy})")
    int register(UserManager entity);


}
