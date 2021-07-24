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

    //接收Map & insert标签的使用
    int insertAdmin(Map map);

    //接收实体pojo & insert标签的使用
    int insertPojo(Admin admin);

    //update标签的使用
    int updateAdmin(Map map);

    //delete标签的使用
    int deleteAdminById(int id);


}
