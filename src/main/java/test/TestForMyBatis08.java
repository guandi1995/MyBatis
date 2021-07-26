package test;

import com.mapper.CacheMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * test for mybatis
 * mybatis cache缓存
 * @author Di Guan on 7/23/2021 6:34 PM
 */

public class TestForMyBatis08 {
    public static void main(String[] args) {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("config/mybatis.xml");
            //创建sqlsessionfactory工厂，读取mybatis.xml主配置文件
            SqlSessionFactory sqlSessionFactory = builder.build(resourceAsStream);
            //创建一次sqlsession会话
            SqlSession sqlSession = sqlSessionFactory.openSession();
            CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
            //第一次查询，本地缓存中没有结果集，连接数据库，将返回的结果集存储在本地缓存中
            List<Map> maps = mapper.fetchStudents();
            System.out.println(maps);
            System.out.println("===============");
            //第二次查询，本地缓存中有结果集，直接从本地缓存获取
            List<Map> maps1 = mapper.fetchStudents();
            System.out.println(maps1);
            //进行delete操作，会清空本地缓存所有内容
            mapper.deleteStudentById(21);
            mapper.deleteStudentById(22);
            mapper.deleteStudentById(23);
            sqlSession.commit();
            System.out.println("================");
            //再次查询时，由于缓存被清空，所以直接连接数据库
            List<Map> maps2 = mapper.fetchStudents();
            System.out.println(maps2);

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
