package com.leizhou.dao;

import com.leizhou.pojo.User;
import com.leizhou.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getUserList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.getUser(1);


        System.out.println(user);


        sqlSession.close();
    }


}
