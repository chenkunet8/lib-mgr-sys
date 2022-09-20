package com.ck.chenkunet.springboot.mapper;

import com.ck.chenkunet.springboot.entity.Device;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeviceMapper extends BaseMapper<Device>{
    @Select("select * from lib_device")
    List<Device> selectAll();

    @Select("select * from lib_device where id = #{id}")
    Device selectOne();
}
