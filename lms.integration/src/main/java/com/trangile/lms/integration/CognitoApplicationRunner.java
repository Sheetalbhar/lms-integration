package com.trangile.lms.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CognitoApplicationRunner implements ApplicationRunner{
	@Value("${aws.accessKeyId}")
    String accessKeyId;
    @Value("${aws.secretAccessKey}")
    String secretAccessKey;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.setProperty("aws.accessKeyId",accessKeyId);
        System.setProperty("aws.secretAccessKey",secretAccessKey);
		
	}

}
