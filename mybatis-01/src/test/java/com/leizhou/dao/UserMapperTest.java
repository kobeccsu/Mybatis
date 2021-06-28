package com.leizhou.dao;

import com.leizhou.pojo.User;
import com.leizhou.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getUserList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void SholdGetSingleUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void insert(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int user = mapper.addUser(new User(4, "慧", "123456"));
        sqlSession.commit();
        System.out.println(user);

        sqlSession.close();

    }

    @Test
    public void  update(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int user = mapper.updateUser(new User(4, "啊慧", "123456"));
        sqlSession.commit();

        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void delete(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUser(4);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insert2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> stringObjectMap = new HashMap<String, Object>();
        stringObjectMap.put("userid", 5);
        stringObjectMap.put("username", "何昭慧");
        stringObjectMap.put("password", "123456");
        int user = mapper.addUser2(stringObjectMap);
        sqlSession.commit();
        System.out.println(user);

        sqlSession.close();

    }

    @Test
    public void shouldGetByLikeName(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.getUserLike("磊%");

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
