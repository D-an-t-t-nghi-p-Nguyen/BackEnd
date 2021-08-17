package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.OderEntity;
import com.example.demo.entity.OderRequest;

public interface OderService {

	List<OderEntity>GetOder();
	List<OderEntity>GetOderByBlog(Integer blog_id);
	OderEntity CreateOder(OderRequest oderRequest );
	OderEntity GetOderById(OderEntity oderEntity );
	OderEntity UpdateOder(OderRequest oderRequest );
	OderEntity DeleteOder(Integer id);
}
