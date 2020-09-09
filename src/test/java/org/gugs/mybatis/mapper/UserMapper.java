package org.gugs.mybatis.mapper;

import org.gugs.mybatis.model.User;

import java.util.List;

public interface UserMapper {
  List<User> getUser(User user);

  User getUserById(Long id);

  void insertUser(User user1);
}
