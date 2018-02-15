package com.springboot.jpa;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.jpa.entity.User;
import com.springboot.jpa.service.IUserService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserserviceTest {
	
	@Autowired
	IUserService mUserService;

	@Test
	public void testSaveUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByUsername() {
		User result = mUserService.findByUsername("Alex");
		assertThat(result.getUsername(), is("Alex"));
	}

	@Test
	public void testFindUser() {
		fail("Not yet implemented");
	}

}
