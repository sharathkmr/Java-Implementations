package com.boot.profiles;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.boot.profiles.configuration.Configuration;
import com.boot.profiles.properties.ApplicationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
public class BootProfilesApplication {
	
	private static Logger logger = Logger.getLogger(BootProfilesApplication.class);

    @Autowired
    private ApplicationProperties properties;

    @Autowired
    private Configuration configuration;

	public static void main(String[] args) {
		SpringApplication.run(BootProfilesApplication.class, args);
	}
	
	@PostConstruct
    private void init(){
        logger.info("Spring Boot - active profile: " + configuration.getName());
        logger.info("Spring Boot - Choosing Your Profile and @Profile annotation example");
        logger.info(properties.toString());

    }
}
