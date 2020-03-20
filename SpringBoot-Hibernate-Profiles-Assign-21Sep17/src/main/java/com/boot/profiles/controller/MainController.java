package com.boot.profiles.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.profiles.model.User;



@RestController
public class MainController {
	
	private Logger logger = Logger.getLogger(MainController.class);
	
	@RequestMapping("/hello")
	String getMessage(@RequestParam(value = "name") String name) {
		String rsp = "Hi " + name + " : responded on - " + new Date()+" : endpoints : /user";
		
		logger.debug("user has clicked : ");
		logger.debug("/hello endpoint "+rsp);
		
		return rsp;
	}
	
	@RequestMapping("/user")
	String getUser() {
		String rsp = "Good Evening !! this is a spring boot logging example";
		
		logger.debug("user has clicked : ");
		logger.debug("/user endpoint "+rsp);
		
		return rsp;
	}
	
	@RequestMapping("/user/{name}")
	User getUserDefault(@PathVariable String name ) {
		User u = new User(1, name, "Administartor");
		
		logger.debug("user has clicked : ");
		logger.debug("/user/"+name+" endpoint ");
		logger.debug(u);
		
		return u;
	}

}
