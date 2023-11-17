package com.example.ProductManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProductManagement.model.User;

public interface userRepository extends JpaRepository<User, Integer>{

	User findByUsernameAndPassword(String username,String password);
}
