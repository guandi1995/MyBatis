package com.mapper;

import java.util.List;
import java.util.Map;

public interface AdminMapper {
    List<Map> selectAdmin();
    List<Map> fecthAdminByID(int id);
}
