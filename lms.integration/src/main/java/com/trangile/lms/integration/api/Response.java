package com.trangile.lms.integration.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
	
	private String result;
	private String msg;
	private ResponseData data ;
	

}
