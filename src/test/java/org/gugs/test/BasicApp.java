package org.gugs.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.gugs.test.clazz.ChildClazz;
import org.gugs.test.mapper.UserMapper;
import org.gugs.test.model.User;
import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

public class BasicApp {

    @Test
    public void testHash() {
      Type genericSuperclass = ChildClazz.class.getGenericSuperclass();
      System.err.println(genericSuperclass.getTypeName());
      Type[] genericInterfaces = ChildClazz.class.getGenericInterfaces();
      for (Type genericInterface : genericInterfaces) {
        System.err.println(genericInterface.getTypeName());
      }
    }

    public static void main(String[] orgs) throws SQLException {
        SqlSessionFactory sqlSessionFactory;
        SqlSession session = null;
        try {
            String resource = "org/gugs/test/mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();
            //User user = session.selectOne("queryById");
            //System.out.println("user: "+user);
//            List<User> list = session.selectList("queryById");
//            System.out.println("list: "+list);
//            User user = new User();
//            user.setUsername("user1234");
//            user.setPassword("123");
//            int userUpdate = session.update("userUpdate", user);
            //session.commit();
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<User> users = mapper.queryById(new User());
            System.err.println("users:"+ users);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if(session != null){
                session.close();
            }
        }
    }
}
