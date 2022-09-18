package com.ck.chenkunet.springboot.mapper;

import com.ck.chenkunet.springboot.entity.UserManager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserManagerMapper {

    @Select("select * from lib_user_manager")
    UserManager selectAll();
}
