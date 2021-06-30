package com.leizhou.dao;

import com.leizhou.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int addBlog(Blog blog);

    List<Blog> queryBlogIF(Map map);

    List<Blog> queryBlogChoose(Map map);

    int updateBlog(Map map);

    List<Blog> getBlogsForeach(Map map);
}
