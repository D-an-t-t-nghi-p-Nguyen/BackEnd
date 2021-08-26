package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CommentEntity;
import com.example.demo.entity.CommentRequest;

public interface CommentService {
	
	List<CommentEntity>GetComment();
	List<CommentEntity>GetCommentByBlog(Integer blog_id);
	CommentEntity CreateComment(CommentRequest commentRequest );
	CommentEntity GetCommentById(CommentEntity commentEntity );
	CommentEntity UpdateComment(CommentRequest commentRequest );
	CommentEntity DeleteComment(Integer id);
}
