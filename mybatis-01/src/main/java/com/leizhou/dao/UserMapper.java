package com.leizhou.dao;

import com.leizhou.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    User getUserById(int id);

    int addUser(User user);

    int addUser2(Map user);

    int updateUser(User user);

    int deleteUser(int id);

    List<User> getUserLike(String username);

}
