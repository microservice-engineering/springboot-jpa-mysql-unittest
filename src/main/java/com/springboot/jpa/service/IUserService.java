package com.springboot.jpa.service;

import com.springboot.jpa.entity.User;

public interface IUserService {
	
	int saveUser(User user);
	
	User findByUsername(String username);
	
	User findUser(String name);
	
}
