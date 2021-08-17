package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BlogEntity;

@Repository
public interface BlogDao extends JpaRepository<BlogEntity, Integer> {

	@Query(value="SELECT * FROM blog WHERE is_delete = 0",nativeQuery = true)
	List<BlogEntity>findAllBlog();

	@Query(value = "SELECT * FROM blog WHERE user_id = ?1", nativeQuery = true)
	List<BlogEntity> listBlogByUser(int userID);
}
