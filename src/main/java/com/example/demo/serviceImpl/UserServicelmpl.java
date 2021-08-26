package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RoleDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Roles;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserRequest;
import com.example.demo.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServicelmpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<UserEntity> getAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public UserEntity AddUser(UserRequest entity) {
    	UserEntity userEntity = new UserEntity();
    	Roles role = new Roles();      	
    	userEntity.setPassword(entity.getPassword());
    	userEntity.setEmailId(entity.getEmailId());
    	userEntity.setUserName(entity.getUserName());
    	Optional<Roles> optionalRole = roleDao.findById(entity.getRole_id());
    	role = optionalRole.get();
    	userEntity.setRole_id(role);
    	 userEntity.setIs_Delete(false);
        return userDao.save(userEntity);
    }

    @Override
    public UserEntity GetUserById(UserEntity entity) {
        return userDao.save(entity);
    }


    @Override
	public UserEntity DeleteUser(Integer id) {
		 UserEntity userEntity =userDao.findById(id).orElseThrow();
		 userEntity.setIs_Delete(true);
		 return userDao.save(userEntity);
	}


    @Override
    public UserEntity fetchUserEntityByEmailId(String email_id) {
        return userDao.findByEmailId(email_id);
    }

    @Override
    public UserEntity fetchUserEntityByEmailIdAndPassword(String email_id, String password) {
        return userDao.findByEmailIdAndPassword(email_id,password);
    }

    @Override
    public List<Roles> getallRoles() {
        return roleDao.findAll();
    }

	@Override
	public UserEntity UpdateUser(UserRequest userRequest, Integer id) {
		// TODO Auto-generated method stub
		UserEntity  entity= userDao.findById(id).orElseThrow();
		entity.setEmailId(userRequest.getEmailId());
		entity.setUserName(userRequest.getUserName());
//		entity.setAvatar(userRequest.getAvatar());
		entity.setPassword(userRequest.getPassword());
    	entity.setRole_id(roleDao.findById(userRequest.getRole_id()).orElseThrow());
    	
		return userDao.save(entity);
		
	}
}
