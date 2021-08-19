package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.NewsEntity;

public interface NewsDao extends JpaRepository<NewsEntity, Integer> {
	
	@Query(value="SELECT * FROM news WHERE is_delete = 0",nativeQuery = true)
	List<NewsEntity>findAllNews();
	
	@Query(value="SELECT * FROM news WHERE user_id = ?1",nativeQuery = true)
	List<NewsEntity>findNewsByUser(int userID);

}
