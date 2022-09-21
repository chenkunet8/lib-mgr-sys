package com.ck.chenkunet.springboot.mapper;

import com.ck.chenkunet.springboot.entity.UserTeacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserTeacherMapper extends BaseMapper<UserTeacher> {
    @Select("select * from lib_user_teacher")
    List<UserTeacher> selectAll();

    @Select("select id from lib_user_teacher where phone=#{phone} and pwd=#{pwd}")
    int login(UserTeacher entity);

    /**
     * 更新教师注册状态
     * @param entity
     * @return
     */
    @Update("update lib_user_teacher set status=#{status} where id=#{id}")
    int updateById(UserTeacher entity);

}
