package com.trangile.lms.integration.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	
	String username;
	String password;
	String email;
	String client_id;
	
	

}
