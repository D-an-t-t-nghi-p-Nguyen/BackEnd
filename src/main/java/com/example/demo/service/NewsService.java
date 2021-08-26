package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.NewsEntity;
import com.example.demo.entity.NewsRequest;

public interface NewsService {
	
	List<NewsEntity> GetNews();
	List<NewsEntity> GetAllNewsByUser(String email);
	NewsEntity AddNews (NewsRequest newsRequest);
	NewsEntity GetNewsById (NewsEntity newsEntity);
	NewsEntity UpdateNews (NewsRequest newsRequest, Integer id);
	NewsEntity DeleteNews (Integer id);

}
