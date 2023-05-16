package com.trangile.lms.integration.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class CognitoApplicationRunner implements ApplicationRunner{
	 	@Value("${aws.accessKeyId}")
	    String accessKeyId;
	    @Value("${aws.secretAccessKey}")
	    String secretAccessKey;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
