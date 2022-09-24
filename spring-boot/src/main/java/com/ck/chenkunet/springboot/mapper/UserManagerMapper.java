package com.ck.chenkunet.springboot.mapper;

import com.ck.chenkunet.springboot.entity.UserManager;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserManagerMapper extends BaseMapper<UserManager> {

    @Select("select * from lib_user_manager")
    List<UserManager> selectAll();

    @Select("select id from lib_user_manager where phone=#{phone} and pwd=#{pwd}")
    int login(UserManager entity);

    @Insert("insert into lib_user_manager (name,pwd,status) values (#{name},#{pwd},#{status})")
    int register(UserManager entity);

}
