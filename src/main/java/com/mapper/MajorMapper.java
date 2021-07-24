package com.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface MajorMapper {
    @Select("select * from major")
    List<Map> fetchMajors();
}
