package com.springboot.jpa.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jpa.entity.User;
import com.springboot.jpa.repository.UserRepository;
import com.springboot.jpa.service.IUserService;

@Service
public class UserServiceImpl  implements IUserService {
	
	@Autowired
	UserRepository mUserRepository;

	@Override
	public int saveUser(User user) {
		mUserRepository.save(user);
		return 0;
	}

	@Override
	public User findByUsername(String username) {
		return mUserRepository.findByUsername(username);
	}

	@Override
	public User findUser(String name) {
		return mUserRepository.findUser(name);
	}
	
	

}
