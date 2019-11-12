package org.gugs.test.mapper;

import org.gugs.test.model.User;

import java.util.List;

public interface UserMapper {
    List<User> queryById(User user) throws Exception;
    void userInsert(User user) throws Exception;
    void userUpdate(User user) throws Exception;
}
