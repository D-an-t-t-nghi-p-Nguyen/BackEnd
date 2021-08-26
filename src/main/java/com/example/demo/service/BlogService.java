package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.BlogEntity;
import com.example.demo.entity.BlogRequest;

public interface BlogService {

	List<BlogEntity> GetBlog();
	List<BlogEntity>GetAllBlogByUser(String email );
	BlogEntity AddBlog(BlogRequest blogRequest );
	BlogEntity GetBlogById(BlogEntity blogEntity );
	BlogEntity UpdateBlog(BlogRequest blogRequest, Integer id);
	BlogEntity DeleteBlog(Integer id );
}
