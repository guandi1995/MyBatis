package test;

import com.mapper.AdminMapper;
import com.mapper.StudentResultMapMapper;
import com.pojo.MajorPojo;
import com.pojo.StudentPojo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * test for mybatis
 * resultMap的使用：
 * - 手动映射
 * - 多对一嵌套映射
 * - 一对多嵌套映射
 *
 * @author Di Guan on 7/23/2021 6:34 PM
 */

public class TestForMaybtis04 {
    public static void main(String[] args) {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("config/mybatis.xml");
            SqlSessionFactory sqlSessionFactory = builder.build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            StudentResultMapMapper mapper = sqlSession.getMapper(StudentResultMapMapper.class);
            //resultMap使用场景一：手动映射无法映射的column
            List<StudentPojo> lists = mapper.fetchStudents();
            System.out.println(lists);

            //resultMap使用场景二：多对一嵌套映射（多个学生对一个专业）
            //注意：如果开启驼峰命名，则major实体中的attribute无法与数据库表column自动映射，因为有下划线
            //如果关闭驼峰命名，则student实体的attribute majorId与数据库表column major_id将无法自动映射
//            List<StudentPojo> studentPojos = mapper.fetchStudentsMajor();
//            System.out.println(studentPojos);
//
//            //resultMap使用场景二：一对多嵌套映射（一个专业对多个学生）
//            List<MajorPojo> majorPojos = mapper.fetchMajorStudents();
//            for (MajorPojo major: majorPojos) {
//                System.out.println(major.getMajor_code()+"--"+major.getStuLists());
//            }

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
