package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity,Integer> {
 UserEntity findByEmailId(String email_id);
 UserEntity findByEmailIdAndPassword(String email_id,String password);
 @Query(value="SELECT * FROM user WHERE is_delete = 0",nativeQuery = true)
 List<UserEntity>findAllUser();
}
