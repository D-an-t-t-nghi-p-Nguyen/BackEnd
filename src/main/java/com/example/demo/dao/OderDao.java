package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.OderEntity;

public interface OderDao extends JpaRepository<OderEntity, Integer> {

	@Query(value="SELECT * FROM oder WHERE is_delete = 0",nativeQuery = true)
	List<OderEntity>findAllOder();
	@Query(value="SELECT * FROM oder WHERE is_delete = 1",nativeQuery = true)
	List<OderEntity>findDeleteOder();
	@Query(value="SELECT * FROM oder WHERE motel_id=?1",nativeQuery = true)
	List<OderEntity>ListOderByBlog(int motel_id);
}
