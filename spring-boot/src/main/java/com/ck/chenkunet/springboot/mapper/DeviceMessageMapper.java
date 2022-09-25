package com.ck.chenkunet.springboot.mapper;

import com.ck.chenkunet.springboot.entity.DeviceMessage;
import com.ck.chenkunet.springboot.entity.DeviceMessageInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeviceMessageMapper extends BaseMapper<DeviceMessage>{
    @Select("select * from lib_device_message order by time desc")
    List<DeviceMessage> selectAll();

    @Select({"<script>"
            + " SELECT a.id,a.time,a.comment,a.type,b.phone,b.name as s_name,c.name,d.name as m_name "
            + " FROM lib_device_message a "
            + " left join lib_user_student b  "
            + " on a.user_id =b.id"
            + " left join lib_device c "
            + " on a.device_id = c.id "
            + " left join lib_user_manager d "
            + " on a.manager_id = d.id "
            + " order by a.time desc "
            + "</script>"})
    List<DeviceMessageInfo> selectAllDeviceMessageInfo();

    @Insert("insert into lib_device_message (device_id,type,time,manager_id,user_id,comment) values (#{deviceId},#{type},#{time},#{managerId},#{userId},#{comment})")
    int register(DeviceMessage entity);

    @Select("SELECT * FROM lib_device_message where device_id =#{deviceId} limit 1")
    DeviceMessage selectOneByDeviceId(int deviceId);
}
