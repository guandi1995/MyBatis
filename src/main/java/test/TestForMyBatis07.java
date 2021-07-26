package test;

import com.mapper.AdminMapper;
import com.mapper.DynamicSQLMapper;
import com.pojo.Admin;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 动态SQL：
 * - if标签
 * - choose标签
 * - trim标签
 * - foreach标签
 * @author Di Guan on 7/25/2021 6:24 PM
 */

public class TestForMyBatis07 {
    public static void main(String[] args) {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("config/mybatis.xml");
            SqlSessionFactory sqlSessionFactory = builder.build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();


            DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
            /**
             * if, choose标签
             */
//            HashMap<String, Object> map = new HashMap<>();
////            map.put("stuname","sijia");
//            map.put("age", 10);
//            map.put("gender", "F");
//            List<Map> lists = mapper.fetchByCondition(map);
//            System.out.println(lists);

            /**
             * trim标签
             */
//            HashMap<String, Object> map1 = new HashMap<>();
//            map1.put("stuname","sijia");
//            map1.put("age", 10);
//            map1.put("gender", "Male");
//            List<Map> list1 = mapper.fetchByCondition2(map1);
//            System.out.println(list1);

            /**
             * 选择修改
             */
//            HashMap<String, Object> map2 = new HashMap<>();
//            map2.put("stuname","sijia");
//            map2.put("gender", "Male");
//            map2.put("stuid", 10);
//            mapper.updateByCondition(map2);


            /**
             * foreach标签: in(?,?,?)
             */
            //传递map参数
//            HashMap<String, Object> map3 = new HashMap<>();
//            map3.put("stuid", 10);
//            map3.put("age_range", new int[]{24,25,26});
//            List<Map> list2 = mapper.fetchByCondition3(map3);
//            System.out.println(list2);
            //传递array参数
//            List<Map> list3 = mapper.fetchByCondition4(new int[]{24, 25, 26});
//            System.out.println(list3);
            //传递list参数
//            ArrayList<Integer> objects = new ArrayList<>();
//            objects.add(24);
//            objects.add(25);
//            objects.add(26);
//            List<Map> list4 = mapper.fetchByCondition5(objects);
//            System.out.println(list4);

            /**
             * foreach标签：批量新增
             */
            HashMap<String, Object> student1 = new HashMap<>();
            student1.put("stuid", 21);
            student1.put("stuname", "Di Guan");
            student1.put("age", 30);
            student1.put("gender", "Male");
            student1.put("major_id", 3);
            HashMap<String, Object> student2 = new HashMap<>();
            student2.put("stuid", 22);
            student2.put("stuname", "sijia");
            student2.put("age", 30);
            student2.put("gender", "Female");
            student2.put("major_id", 2);
            HashMap<String, Object> student3 = new HashMap<>();
            student3.put("stuid", 23);
            student3.put("stuname", "DJ Guan");
            student3.put("age", 5);
            student3.put("gender", "Male");
            student3.put("major_id", 1);
            ArrayList<Object> students = new ArrayList<>();
            students.add(student1);
            students.add(student2);
            students.add(student3);
            mapper.insertBatch(students);
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
