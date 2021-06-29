package com.leizhou.dao;

import com.leizhou.pojo.Student;
import com.leizhou.pojo.Teacher;
import com.leizhou.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TeacherMapperTest {

    @Test
    public void getTeacher() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);

        sqlSession.close();
    }

    @Test
    public void getStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper1 = sqlSession.getMapper(StudentMapper.class);

        List<Student> studentlist = mapper1.getStudent();
        studentlist.forEach(System.out::println);

        sqlSession.close();
    }

    @Test
    public void getStudent1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper1 = sqlSession.getMapper(StudentMapper.class);

        List<Student> studentlist = mapper1.getStudent2();
        studentlist.forEach(System.out::println);

        sqlSession.close();
    }
}