package com.trangile.lms.integration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Application {
	public static void main(String[] args)  {
		ConfigurableApplicationContext context = 
		SpringApplication.run(Application.class, args);
		
		String accesskey = context.getEnvironment().getProperty("aws.accessKeyId");
		
		
			
	}

	

}
