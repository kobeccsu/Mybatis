package com.leizhou.dao;

import com.leizhou.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    User getUserById(@Param("id") int id);

    int updateUser(User user);
}
