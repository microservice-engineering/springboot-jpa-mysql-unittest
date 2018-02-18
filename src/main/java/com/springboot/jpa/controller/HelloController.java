package com.springboot.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.config.ConfigBean;
import com.springboot.jpa.entity.JsonResponse;
import com.springboot.jpa.entity.User;
import com.springboot.jpa.exception.MyException;
import com.springboot.jpa.service.IUserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloController {
	
	@Autowired
	ConfigBean mConfigBean;
	
//	@Autowired
//	MultipleProperities mDevconfigBean;
	
	
	@Autowired
	IUserService mUserService;

    @RequestMapping("/hello")
    public String index() {
    		log.info("testing purpose: {}", "info level");
    		log.debug("testing purpose: {}", "debug level");
        return "Hello,World!";
    }
    
    @RequestMapping("/save")
    public String saveData() {
    		log.info("start to save data: {}", "debug level");
    		User user = new User();
    		user.setUsername("Alex");
    		user.setEmailadress("alex_decimal@126.com");
    		user.setAge(32);
    		user.setPassword("aq1sw2de");
    		mUserService.saveUser(user);
    		return "save successfually";
    }
    
    @RequestMapping("/findByName")
    public JsonResponse<User> findByUsername(@RequestParam("username")  String username ) throws Exception {
    		//throw new MyException("don't know message");
    		JsonResponse<User> response = new JsonResponse<>();
    		User result = mUserService.findByUsername(username);
    		response.setData(result);
    		response.setCode(JsonResponse.OK);
    		response.setSuccess(true);
    		response.setMessage("Get the user successfully");
    		return response;
    }
    
    @RequestMapping("/findUser/{user}")
    public User findUser(
    		@RequestParam("username")  String username,
    		@PathVariable("user") String user
    		) {
    		return mUserService.findUser(username);
    }

}