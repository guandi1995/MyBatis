package com.mapper;

import com.pojo.MajorPojo;
import com.pojo.StudentPojo;

import java.util.List;
import java.util.Map;

public interface StudentResultMapMapper2 {
    //一对多嵌套映射 二次select查询
    List<MajorPojo> fetchMajors();
}
