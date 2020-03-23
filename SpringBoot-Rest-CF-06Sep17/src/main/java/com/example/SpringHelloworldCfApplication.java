package com.example;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringHelloworldCfApplication {
	
	private static Logger logger = Logger.getLogger(SpringHelloworldCfApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringHelloworldCfApplication.class, args);
		logger.debug("application started");
	}
}