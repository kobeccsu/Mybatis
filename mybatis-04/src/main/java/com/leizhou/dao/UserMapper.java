package com.leizhou.dao;

import com.leizhou.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    User getUserById(int id);

    List<User> getUserByLimit(Map<String, Object> pagination);

    List<User> getUserByRowBounds();
}
