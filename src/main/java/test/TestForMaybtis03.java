package test;

import com.mapper.AdminMapper;
import com.pojo.Admin;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * test for mybatis
 * insert, update, delete标签的使用
 * @author Di Guan on 7/23/2021 6:34 PM
 */

public class TestForMaybtis03 {
    public static void main(String[] args) {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("config/mybatis.xml");
            SqlSessionFactory sqlSessionFactory = builder.build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);

            //insert标签的使用
//            HashMap<Object, Object> map = new HashMap<>();
//            map.put("adminid", 8);
//            map.put("adminuser", "insert@purdue.edu");
//            map.put("adminpwd", "123456");
//            map.put("adminname", "insert");
//            int i = mapper.insertAdmin(map);
//            sqlSession.commit();
//            System.out.println(i);

            //update标签的使用
            HashMap<Object, Object> map1 = new HashMap<>();
            map1.put("adminid",8);
            map1.put("adminuser", "update@purdue.edu");
            map1.put("adminpwd", "666666");
            mapper.updateAdmin(map1);
            sqlSession.commit();

            //delete标签的使用
            mapper.deleteAdminById(8);
            sqlSession.commit();

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
