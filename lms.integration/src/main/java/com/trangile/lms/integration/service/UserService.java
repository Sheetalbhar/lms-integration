package com.trangile.lms.integration.service;

import java.util.HashMap;
import java.util.List;

import com.trangile.lms.integration.model.User;


public interface UserService {
	
	HashMap<String, Object> validateUser(User user);

	User getUser(String username);

	List<User> getAllUsers();

}
