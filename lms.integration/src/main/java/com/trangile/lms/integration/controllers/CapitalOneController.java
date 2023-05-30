package com.trangile.lms.integration.controllers;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trangile.lms.integration.api.Response;
import com.trangile.lms.integration.api.request.VerifyRequest;
import com.trangile.lms.integration.capitalOnePartner.CapitalOneRepository;
import com.trangile.lms.integration.capitalOnePartner.CapitalOneService;
import com.trangile.lms.integration.model.TokenResponse;



@RestController
public class CapitalOneController {
	@Autowired
	private CapitalOneService capitalOneService;
	
	@Autowired
	private CapitalOneRepository capitalOneRepository;
	@GetMapping("/")
	public Object home() {
		return "success";
	}
	
	
	
	@PostMapping("/capitalOne/verify")
	public Object verifyRequest(@RequestParam(value = "cardNo", required = false) String cardNo,
			@RequestParam(value = "locationID", required = false) String locationID) {
		VerifyRequest verifyRequest = new VerifyRequest();
		verifyRequest.setCardNo(cardNo);
		verifyRequest.setLocationID(locationID);
		Response response =capitalOneService.Verify(verifyRequest);
		System.out.println("response====="+response);
		//TokenResponse tokenResponse= capitalOneRepository.getNewToken();
//		if(tokenResponse!=null) {
//			System.out.println("tokenResponse------"+tokenResponse.getToken_type());
//			return tokenResponse;
//		}
		return response;
		
		
	}
	

}
