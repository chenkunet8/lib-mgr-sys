package com.ck.chenkunet.springboot.mapper;

import com.ck.chenkunet.springboot.entity.DeviceType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeviceTypeMapper extends BaseMapper<DeviceType>{
    @Select("select * from lib_device_type")
    List<DeviceType> selectAll();
}
