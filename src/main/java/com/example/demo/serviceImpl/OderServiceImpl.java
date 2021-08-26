package com.example.demo.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BlogDao;
import com.example.demo.dao.OderDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.OderEntity;
import com.example.demo.entity.OderRequest;
import com.example.demo.service.OderService;

@Service
public class OderServiceImpl implements OderService {

	@Autowired
	private OderDao oderDao;
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<OderEntity> GetOderDelete(){
		return oderDao.findDeleteOder();
	}
	
	@Override
	public List<OderEntity> GetOder() {
		return oderDao.findAllOder();
	}

	@Override
	public List<OderEntity> GetOderByBlog(Integer blog_id) {

		return oderDao.ListOderByBlog(blog_id);
	}

	@Override
	public OderEntity CreateOder(OderRequest oderRequest) {
		OderEntity entity = new OderEntity();
		Date date = new java.util.Date();
		entity.setAmount(oderRequest.getAmount());
		entity.setPrice(oderRequest.getPrice());
		entity.setDateBooking(date);
		entity.setDateGo(oderRequest.getDateGo());
		entity.setIs_Delete(false);
		entity.setMotel_id(blogDao.findById(oderRequest.getMotel_id()).orElseThrow());
		entity.setNumber(oderRequest.getNumber());
		entity.setUser_id(userDao.findByEmailId(oderRequest.getEmail()));
		return oderDao.save(entity);
	}

	@Override
	public OderEntity GetOderById(OderEntity oderEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OderEntity UpdateOder(OderRequest oderRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OderEntity DeleteOder(Integer id) {
		OderEntity oderService = oderDao.findById(id).orElseThrow();
		oderService.setIs_Delete(true);
		return oderDao.save(oderService);
	}



}
