package test;

import com.mapper.StudentResultMapMapper;
import com.mapper.StudentResultMapMapper2;
import com.pojo.MajorPojo;
import com.pojo.StudentPojo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * test for mybatis
 * resultMap的使用:
 * - 一对多 或 多对一的二次select查询
 * @author Di Guan on 7/23/2021 6:34 PM
 */

public class TestForMaybtis05 {
    public static void main(String[] args) {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("config/mybatis.xml");
            SqlSessionFactory sqlSessionFactory = builder.build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            StudentResultMapMapper2 mapper = sqlSession.getMapper(StudentResultMapMapper2.class);

            //一对多的二次查询
            List<MajorPojo> pojos = mapper.fetchMajors();
            for (MajorPojo major : pojos) {
                System.out.println(major.getMajor_code()+"--"+major.getStuLists());
            }

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
