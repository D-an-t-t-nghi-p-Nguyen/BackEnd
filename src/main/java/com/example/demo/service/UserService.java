package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Roles;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserRequest;

public interface UserService {
    List<UserEntity> getAllUser();
    List<Roles> getallRoles();
    UserEntity AddUser(UserRequest userRequest);
    UserEntity GetUserById(UserEntity entity);
    UserEntity UpdateUser(UserRequest userRequest, Integer id);
    UserEntity fetchUserEntityByEmailId(String email_id);
    UserEntity fetchUserEntityByEmailIdAndPassword(String email_id ,String password);
    UserEntity DeleteUser(Integer id);


}
