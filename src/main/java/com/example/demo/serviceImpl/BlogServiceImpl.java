package com.example.demo.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BlogDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.BlogEntity;
import com.example.demo.entity.BlogRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<BlogEntity> GetBlog() {
		// TODO Auto-generated method stub
		return blogDao.findAllBlog();
	}

	@Override
	public List<BlogEntity> GetAllBlogByUser(String email) {
		UserEntity userByEmail = userDao.findByEmailId(email);
		List<BlogEntity> listBlog = blogDao.listBlogByUser(userByEmail.getId());
		return listBlog;
	}

	@Override
	public BlogEntity AddBlog(BlogRequest blogRequest) {
		BlogEntity entity = new BlogEntity();
		Date date = new java.util.Date();
		entity.setAddress(blogRequest.getAddress());
		entity.setContent(blogRequest.getContent());
		entity.setDateSubmit(date);
		entity.setImage(blogRequest.getImage());
		entity.setIs_Delete(false);
		entity.setName(blogRequest.getName());
		entity.setPrice(blogRequest.getPrice());
		entity.setUser_id(userDao.findByEmailId(blogRequest.getEmail()));
		return blogDao.save(entity);
	}

	@Override
	public BlogEntity GetBlogById(BlogEntity blogEntity) {
		// TODO Auto-generated method stub
		return blogDao.save(blogEntity); 	
	}

	@Override
	public BlogEntity UpdateBlog(BlogRequest blogRequest, Integer id) {
		BlogEntity entity = blogDao.findById(id).orElseThrow();
		Date date = new java.util.Date();
		entity.setAddress(blogRequest.getAddress());
		entity.setContent(blogRequest.getContent());
		entity.setDateSubmit(date);
		entity.setImage(blogRequest.getImage());
		entity.setIs_Delete(false);
		entity.setName(blogRequest.getName());
		entity.setPrice(blogRequest.getPrice());
		entity.setUser_id(userDao.findByEmailId(blogRequest.getEmail()));
		return blogDao.save(entity);
	}

	@Override
	public BlogEntity DeleteBlog(Integer id) {
		BlogEntity entity = blogDao.findById(id).orElseThrow();
		entity.setIs_Delete(true);
		return blogDao.save(entity);
	}
	
	
	
	

}
