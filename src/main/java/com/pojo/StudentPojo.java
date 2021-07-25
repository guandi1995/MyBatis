package com.pojo;

/**
 * @author Di Guan on 7/24/2021 6:56 PM
 */

public class StudentPojo {
    private Integer stuid;
    private String stuname;
    //数据库的column名是age，实体类中的attribute是stuage（名字不一致，也无法使用驼峰命名进行自动映射）
    //这时可以使用resultMap指明映射关系
    private Integer stuage;
    private String gender;
    //数据库的column名是major_id, 实体类中的attribute是majorid（名字不一致，但是只是下划线或大小写差别）
    //使用驼峰命名实现自动映射，需要在mybatis.xml主配置文件中设置开启驼峰命名
    private Integer majorId;

    //StudentPojo学生实体是多对一和一对多关系中多的一端，所以在学生实体中存储一的实体即可
    private MajorPojo major;

    @Override
    public String toString() {
        return "StudentPojo{" +
                "stuid=" + stuid +
                ", stuname='" + stuname + '\'' +
                ", stuage=" + stuage +
                ", gender='" + gender + '\'' +
                ", majorId=" + majorId +
                ", major=" + major +
                '}';
    }

    public MajorPojo getMajor() {
        return major;
    }

    public void setMajor(MajorPojo major) {
        this.major = major;
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public Integer getStuage() {
        return stuage;
    }

    public void setStuage(Integer stuage) {
        this.stuage = stuage;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorid) {
        this.majorId = majorid;
    }
}
