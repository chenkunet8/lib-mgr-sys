package com.ck.chenkunet.springboot.mapper;

import com.ck.chenkunet.springboot.entity.DeviceMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeviceMessageMapper extends BaseMapper<DeviceMessage>{
    @Select("select * from lib_device_message")
    List<DeviceMessage> selectAll();
}
