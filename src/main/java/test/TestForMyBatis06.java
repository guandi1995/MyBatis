package test;

import com.mapper.AdminMapper;
import com.mapper.StudentResultMapMapper2;
import com.pojo.Admin;
import com.pojo.MajorPojo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 新增主键
 * @author Di Guan on 7/25/2021 6:24 PM
 */

public class TestForMyBatis06 {
    public static void main(String[] args) {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("config/mybatis.xml");
            SqlSessionFactory sqlSessionFactory = builder.build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
            Admin admin = new Admin();
            admin.setUsername("random@email.com");
            admin.setPassword("123123");
            admin.setName("random");
            int i = mapper.insertReturnKey(admin);
            sqlSession.commit();
            System.out.println(i);//如果insert成功，返回1，表示影响条数
            System.out.println(admin.getId());//如果insert成功，返回新增的主键id的值

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
