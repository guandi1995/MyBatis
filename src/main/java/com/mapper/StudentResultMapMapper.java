package com.mapper;

import com.pojo.MajorPojo;
import com.pojo.StudentPojo;

import java.util.List;

public interface StudentResultMapMapper {
    List<StudentPojo> fetchStudents();
    //多对一嵌套映射
    List<StudentPojo> fetchStudentsMajor();
    //一对多嵌套映射
    List<MajorPojo> fetchMajorStudents();
}
