package com.leizhou.dao;

import com.leizhou.pojo.Blog;
import com.leizhou.utils.IDUtils;
import com.leizhou.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class BlogMapperTest {

    @Test
    public void addBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtils.getUUID());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("磊霸王");
        blog.setCreateTime(new Date());
        blog.setViews(999);

        mapper.addBlog(blog);

        blog.setId(IDUtils.getUUID());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getUUID());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getBlogs() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, Object> map = new HashMap<>();
        map.put("title", "微服务如此简单");
        List<Blog> blogs = mapper.queryBlogChoose(map);

        blogs.forEach(System.out::println);
    }

}