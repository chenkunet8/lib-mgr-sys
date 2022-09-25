package com.ck.chenkunet.springboot.mapper;

import com.ck.chenkunet.springboot.entity.DeviceInfo;
import com.ck.chenkunet.springboot.entity.DeviceMessage;
import com.ck.chenkunet.springboot.entity.DeviceMessageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeviceMessageMapper extends BaseMapper<DeviceMessage>{
    @Select("select * from lib_device_message")
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
            + "</script>"})
    List<DeviceMessageInfo> selectAllDeviceMessageInfo();
}
