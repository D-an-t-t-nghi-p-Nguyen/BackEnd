package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Roles;

@Repository
public interface RoleDao extends JpaRepository<Roles,Integer> {
}
