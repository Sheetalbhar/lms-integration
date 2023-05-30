package com.trangile.lms.integration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trangile.lms.integration.capitalOnePartner.CapitalOneRepository;
import com.trangile.lms.integration.model.TokenResponse;



@RestController
public class CapitalOneController {
	@Autowired
	private CapitalOneRepository capitalOneRepository;
	@GetMapping("/")
	public Object home() {
		return "success";
	}
	
	
	
	@GetMapping("/capitalOne/auth")
	public Object token(@RequestParam(value = "grant_type", required = false) String grantType,
			@RequestParam(value = "client_id", required = false) String clientId,
			@RequestParam(value = "client_secret", required = false) String clientSecret,
			@RequestParam(value = "code", required = false) String code) {
		/*
		 * log.info(this.getClass() + " token ::  >> clientSecret : " + clientSecret +
		 * ", grantType : " + grantType + ", clientId : " + clientId + ", code : " +
		 * code);
		 */
		TokenResponse tokenResponse= capitalOneRepository.getNewToken();
		if(tokenResponse!=null) {
			System.out.println("tokenResponse------"+tokenResponse.getToken_type());
			return tokenResponse;
		}
		return null;
		
		
	}
	

}
