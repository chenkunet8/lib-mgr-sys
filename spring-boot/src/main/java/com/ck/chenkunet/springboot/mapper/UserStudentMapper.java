package com.ck.chenkunet.springboot.mapper;

import com.ck.chenkunet.springboot.entity.UserStudent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserStudentMapper extends BaseMapper<UserStudent>{
    @Select("select * from lib_user_student")
    List<UserStudent> selectAll();
}