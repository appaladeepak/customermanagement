package com.example.ProductManagement.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.ProductManagement.model.User;
import com.example.ProductManagement.repository.userRepository;

@Component
public class UserImplementation {

	@Autowired
	private userRepository userrepo;
	public User login(String username,String password) {
		User u=userrepo.findByUsernameAndPassword(username, password);
		//System.err.println(u.getId());
		return u;
	}
}
