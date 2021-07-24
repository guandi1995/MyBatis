package test;

import com.mapper.AdminMapper;
import com.mapper.MajorMapper;
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
 *
 * @author Di Guan on 7/23/2021 6:34 PM
 */

public class TestForMaybtis {
    public static void main(String[] args) {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("config/mybatis.xml");
            //创建sqlsessionfactory工厂，读取mybatis.xml主配置文件
            SqlSessionFactory sqlSessionFactory = builder.build(resourceAsStream);
            //创建一次sqlsession会话
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //在sqlsession会话中，执行SQL语句
            //方式一：namespace:mapper文件 + id:SQL语句
//            List<Object> objects = sqlSession.selectList("mapper.selectStu");
//            System.out.println(objects);

            //方式二: namespace:接口名 + id:接口方法名
//            AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
//            List<Map> maps = mapper.selectAdmin();
//            System.out.println(maps);
//
//            List<Map> maps1 = mapper.fecthAdminByID(2);
//            System.out.println(maps1);

            //方式三：接口+注解（写在方法上面）
            MajorMapper mapper = sqlSession.getMapper(MajorMapper.class);
            List<Map> maps = mapper.fetchMajors();
            System.out.println(maps);
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
