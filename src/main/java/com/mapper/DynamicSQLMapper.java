package com.mapper;

import java.util.List;
import java.util.Map;

public interface DynamicSQLMapper {
    /**
     * 动态SQL
     * @return
     */

    //if,choose标签
    List<Map> fetchByCondition(Map map);
    //trim标签和where标签
    List<Map> fetchByCondition2(Map map);
    //trim标签应用：选择性修改
    int updateByCondition(Map map);
    //foreach标签：in(?,?,?)
    List<Map> fetchByCondition3(Map map);
    List<Map> fetchByCondition4(int[] arr);
    List<Map> fetchByCondition5(List list);
    //foreach标签：批量新增
    int insertBatch(List list);

}
