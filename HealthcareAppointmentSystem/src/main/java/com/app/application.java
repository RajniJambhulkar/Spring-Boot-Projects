package com.app;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class application {

	public static void main(String[] args) {
		SpringApplication.run(application.class, args);
	}
	

	
	@Bean 
	public ModelMapper modelMapper() {
		
		ModelMapper modelMapper = new ModelMapper(); 
		
		modelMapper.getConfiguration().
		
		setMatchingStrategy(MatchingStrategies.STRICT) 
		
		.setPropertyCondition(Conditions.isNotNull());
		
		return modelMapper;

	}


}
