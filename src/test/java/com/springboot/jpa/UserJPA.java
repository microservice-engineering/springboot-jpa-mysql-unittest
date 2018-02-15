/**  
 * All rights Reserved, Designed By IBM
 * @Title:  UserJPA.java   
 * @Package com.springboot.jpa   
 * @Description:    TODO
 * @author: IBM    
 * @date:   Feb 15, 2018 9:47:58 AM   
 * @version V1.0 
 * @Copyright: 2018 IBM. All rights reserved. 
 */
package com.springboot.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.jpa.entity.User;
import com.springboot.jpa.repository.UserRepository;

/**
 * @author alex
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserJPA {
	
	@Autowired
	UserRepository mUserRepository;

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void findByUsername() {
		User result = mUserRepository.findByUsername("Alex");
		assertThat(result.getUsername(), is("Alex"));
	}

}
