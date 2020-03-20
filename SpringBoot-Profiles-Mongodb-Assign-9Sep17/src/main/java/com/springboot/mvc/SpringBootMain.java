package com.springboot.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootMain {
	
	@Autowired
	private static ApplicationContext appContext;

	public static void main(String[] args) {
		appContext = SpringApplication.run(SpringBootMain.class, args);
		
		String[] beans = appContext.getBeanDefinitionNames();
		
		for (String string : beans) {
			System.out.println(string);
		}
		
	}
}
