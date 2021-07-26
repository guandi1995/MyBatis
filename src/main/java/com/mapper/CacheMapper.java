package com.mapper;

import java.util.List;
import java.util.Map;

public interface CacheMapper {
    List<Map> fetchStudents();
    int deleteStudentById(int stuid);
}
