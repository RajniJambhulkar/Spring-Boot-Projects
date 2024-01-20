package com.app;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Day17RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day17RestApplication.class, args);
	}
	
	
//	Model Mapper: Its primary purpose is to simplify the process of converting data 
//	from one object to another, especially when the two objects have different structures 
//	or when you want to selectively map certain fields.
	
//	@Bean annotation is used to indicate that a method produces a bean to be managed by 
//	the Spring container.
	
	@Bean //equivalent to <bean id ..../> in xml file
	public ModelMapper modelMapper() {
		
		//created a model mapper ka instance
		ModelMapper modelMapper = new ModelMapper(); //created a model mapper ka instance	
		
		modelMapper.getConfiguration().
		
		//only MATCHING prop names n types between src n dest will be transferred , during the mapping
		setMatchingStrategy(MatchingStrategies.STRICT) 
		
		// only non null properties will be transferred from src --> dest , during the mapping
		.setPropertyCondition(Conditions.isNotNull());
		
		//method rets configured ModelMapper instance to SC
		//SC registers it as a spring bean n manages it's life cycle.
		return modelMapper;

	}


}
