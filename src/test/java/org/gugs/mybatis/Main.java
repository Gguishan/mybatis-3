package org.gugs.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.gugs.mybatis.mapper.UserMapper;
import org.gugs.mybatis.model.User;

import java.io.IOException;
import java.io.InputStream;

public class Main {
  public static void main(String[] args) throws IOException {
    InputStream inputStream = Resources.getResourceAsStream("resources/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        List<User> userList = userMapper.getUser(new User());
//        System.err.println(userList);
    final User user = userMapper.getUserById(433429584428400640L);
    System.err.println(user);
  }
}
