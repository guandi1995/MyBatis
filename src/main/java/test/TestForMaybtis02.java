package test;

import com.mapper.AdminMapper;
import com.mapper.MajorMapper;
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
 *
 * @author Di Guan on 7/23/2021 6:34 PM
 */

public class TestForMaybtis02 {
    public static void main(String[] args) {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("config/mybatis.xml");
            SqlSessionFactory sqlSessionFactory = builder.build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
            //单一值
            List<Map> map1 = mapper.fecthAdminByID(2);
            System.out.println(map1);
            //多个值
            List<Map> maps2 = mapper.fecthAdminByConditions("dguan", "123445");
            System.out.println(maps2);
            //Map
            HashMap<Object, Object> map = new HashMap<>();
            map.put("adminid", 6);
            map.put("adminuser", "dguan@purdue.edu");
            map.put("adminpwd", "123456");
            map.put("adminname", "Di Guan");
            int i = mapper.insertAdmin(map);
            System.out.println(i);
            sqlSession.commit();
            //实体pojo
            Admin admin = new Admin();
            admin.setId(7);
            admin.setUsername("random@com");
            admin.setPassword("123456");
            admin.setName("random");
            int j = mapper.insertPojo(admin);
            sqlSession.commit();

            System.out.println(j);

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
