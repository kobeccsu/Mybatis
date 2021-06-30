package com.leizhou.dao;

import com.leizhou.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {


    @Select("select * from user where id = #{id}")
    User getUser(int id);

}
