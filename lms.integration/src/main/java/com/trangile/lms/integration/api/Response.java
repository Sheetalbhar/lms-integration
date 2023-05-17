package com.trangile.lms.integration.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
	
	private String result;
	private String msg;
	private ResponseData data ;
	

}
