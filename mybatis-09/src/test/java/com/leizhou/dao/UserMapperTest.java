package com.leizhou.dao;

import com.leizhou.pojo.User;
import com.leizhou.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.sound.midi.Soundbank;

import static org.junit.Assert.*;

public class UserMapperTest {

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        SqlSession sqlSession1 = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        User user1 = mapper.getUserById(1);
        System.out.println(user1);
        sqlSession.close();



        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        User user2 = mapper1.getUserById(1);

        System.out.println(user2);

        System.out.println(user1 == user2);



        sqlSession1.close();
    }
}