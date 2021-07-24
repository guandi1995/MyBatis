package com.mapper;

import com.pojo.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminMapper {
    List<Map> selectAdmin();

    //接收单一值
    List<Map> fecthAdminByID(int id);

    //接收多个值
    List<Map> fecthAdminByConditions(@Param("uname") String username, @Param("upwd") String password);

    //接收Map
    int insertAdmin(Map map);

    //接收实体pojo
    int insertPojo(Admin admin);
}
