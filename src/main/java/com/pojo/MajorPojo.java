package com.pojo;

import java.util.List;

/**
 * @author Di Guan on 7/24/2021 6:56 PM
 */

public class MajorPojo {
    private Integer major_id;
    private String major_code;
    private String major_name;
    private String major_desc;
    //MajorPojo专业实体是多对一和一对多关系中一的一端，所以在专业实体中，存储多个学生实体，即List<StudentPojo>
    private List<StudentPojo> stuLists;

    @Override
    public String toString() {
        return "MajorPojo{" +
                "major_id=" + major_id +
                ", major_code='" + major_code + '\'' +
                ", major_name='" + major_name + '\'' +
                ", major_desc='" + major_desc + '\'' +
                ", stuLists=" + stuLists +
                '}';
    }

    public Integer getMajor_id() {
        return major_id;
    }

    public void setMajor_id(Integer major_id) {
        this.major_id = major_id;
    }

    public String getMajor_code() {
        return major_code;
    }

    public void setMajor_code(String major_code) {
        this.major_code = major_code;
    }

    public String getMajor_name() {
        return major_name;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }

    public String getMajor_desc() {
        return major_desc;
    }

    public void setMajor_desc(String major_desc) {
        this.major_desc = major_desc;
    }

    public List<StudentPojo> getStuLists() {
        return stuLists;
    }

    public void setStuLists(List<StudentPojo> stuLists) {
        this.stuLists = stuLists;
    }
}
