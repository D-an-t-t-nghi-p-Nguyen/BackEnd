package com.example.demo.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BlogDao;
import com.example.demo.dao.CommentDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.CommentEntity;
import com.example.demo.entity.CommentRequest;
import com.example.demo.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private CommentDao commentDao;
	
	@Override
	public List<CommentEntity> GetComment() {
		return commentDao.findAllComment();
	}

	@Override
	public CommentEntity CreateComment(CommentRequest commentRequest) {
		CommentEntity entity= new CommentEntity();
		Date date = new java.util.Date();
		entity.setComment(commentRequest.getComment());
		entity.setDatecomment(date);
		entity.setIs_Delete(false);
		entity.setUser_id(userdao.findByEmailId(commentRequest.getEmail()));
		entity.setMotel_id(blogDao.findById(commentRequest.getMotel_id()).orElseThrow());
		return commentDao.save(entity);
	}

	@Override
	public CommentEntity GetCommentById(CommentEntity commentEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentEntity UpdateComment(CommentRequest commentRequest) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<CommentEntity> GetCommentByBlog(Integer blog_id) {
		// TODO Auto-generated method stub
		return commentDao.ListCommentByBlog(blog_id);
	}

	@Override
	public CommentEntity DeleteComment(Integer id) {
		CommentEntity commentService = commentDao.findById(id).orElseThrow();
		commentService.setIs_Delete(true);
		return commentDao.save(commentService);
	}
}
