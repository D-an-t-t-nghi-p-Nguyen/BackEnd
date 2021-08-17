package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CommentEntity;

@Repository 
public interface CommentDao extends JpaRepository<CommentEntity, Integer> {
	
	@Query(value="SELECT * FROM comment WHERE is_delete = 0",nativeQuery = true)
	List<CommentEntity>findAllComment();
	@Query(value="SELECT * FROM comment WHERE motel_id=?1",nativeQuery = true)
	List<CommentEntity>ListCommentByBlog(int motel_id);

}
