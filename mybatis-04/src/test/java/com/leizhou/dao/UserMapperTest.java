package com.leizhou.dao;

import com.leizhou.pojo.User;
import com.leizhou.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {
    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getUserList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.getUserById(1);


        System.out.println(user);


        sqlSession.close();
    }

    @Test
    public void testLog4j(){
        logger.info("here is info");
        logger.debug("here is debug");
        logger.error("here is error");
    }

    @Test
    public void getUserListByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("pageIndex", 1);
        map.put("pageSize", 2);
        List<User> userList = userMapper.getUserByLimit(map);

        userList.forEach(System.out::println);



        sqlSession.close();

    }

    @Test
    public void getByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<User> userLst = sqlSession.selectList("com.leizhou.dao.UserMapper.getUserByRowBounds", null, new RowBounds(1,2));
        userLst.forEach(System.out::println);
        sqlSession.close();
    }
}
