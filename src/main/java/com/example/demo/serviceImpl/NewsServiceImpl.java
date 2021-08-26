package com.example.demo.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.NewsDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.NewsEntity;
import com.example.demo.entity.NewsRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDao newsDao;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<NewsEntity> GetNews() {
		return newsDao.findAllNews();
	}

	@Override
	public List<NewsEntity> GetAllNewsByUser(String email) {
		UserEntity userEntity = userDao.findByEmailId(email);
		List<NewsEntity> listNews = newsDao.findNewsByUser(userEntity.getId());
		return listNews;
	}

	@Override
	public NewsEntity AddNews(NewsRequest newsRequest) {
		NewsEntity entity = new NewsEntity();
		Date date = new java.util.Date();
		entity.setContent1(newsRequest.getContent1());
		entity.setContent2(newsRequest.getContent2());
		entity.setDateSubmit(date);
		entity.setImage(newsRequest.getImage());
		entity.setImage1(newsRequest.getImage1());
		entity.setImage2(newsRequest.getImage2());
		entity.setIs_Delete(false);
		entity.setName(newsRequest.getName());
		entity.setUser_id(userDao.findByEmailId(newsRequest.getEmail()));
		return newsDao.save(entity);
	}

	@Override
	public NewsEntity GetNewsById(NewsEntity newsEntity) {
		// TODO Auto-generated method stub
		return newsDao.save(newsEntity);
	}

	@Override
	public NewsEntity UpdateNews(NewsRequest newsRequest, Integer id) {
		NewsEntity entity = newsDao.findById(id).orElseThrow();
				Date date = new java.util.Date();
				entity.setContent1(newsRequest.getContent1());
				entity.setContent2(newsRequest.getContent2());
				entity.setDateSubmit(date);
				entity.setImage(newsRequest.getImage());
				entity.setImage1(newsRequest.getImage1());
				entity.setImage2(newsRequest.getImage2());
				entity.setIs_Delete(false);
				entity.setName(newsRequest.getName());
				entity.setUser_id(userDao.findByEmailId(newsRequest.getEmail()));
				return newsDao.save(entity);
	}

	@Override
	public NewsEntity DeleteNews(Integer id) {
		NewsEntity entity = newsDao.findById(id).orElseThrow();
		entity.setIs_Delete(true);
		return newsDao.save(entity);
	}

}
