/**  
 * All rights Reserved, Designed By IBM
 * @Title:  ControllerTest.java   
 * @Package com.springboot.jpa   
 * @Description:    TODO
 * @author: IBM    
 * @date:   Feb 15, 2018 8:55:25 AM   
 * @version V1.0 
 * @Copyright: 2018 IBM. All rights reserved. 
 */
package com.springboot.jpa;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
	
	@Autowired
    private MockMvc mvc;
    
	/**
	 * Test method for {@link com.springboot.jpa.controller.HelloController#index()}.
	 */
	@Test
	public void testIndex() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.springboot.jpa.controller.HelloController#saveData()}.
	 */
	@Test
	public void testSaveData() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.springboot.jpa.controller.HelloController#findByUsername(java.lang.String)}.
	 */
	@Test
	public void testFindByUsername() {
		try {
			mvc.perform(get("/findByName")
					.param("username", "Alex")
				      .contentType(MediaType.APPLICATION_JSON))
				      .andExpect(status().isOk())
				      .andExpect(MockMvcResultMatchers.content().string("{\"id\":2,\"username\":\"Alex\",\"password\":\"aq1sw2de\",\"age\":32,\"emailadress\":\"alex_decimal@126.com\"}"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.springboot.jpa.controller.HelloController#findUser(java.lang.String)}.
	 */
	@Test
	public void testFindUser() {
		fail("Not yet implemented");
	}

}
