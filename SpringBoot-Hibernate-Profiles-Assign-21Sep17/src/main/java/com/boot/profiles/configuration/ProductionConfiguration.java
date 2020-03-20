package com.boot.profiles.configuration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"prod"})
public class ProductionConfiguration implements Configuration {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Production Configuration";
	}

}
