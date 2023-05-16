package com.trangile.lms.integration.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trangile.lms.integration.model.User;
import com.trangile.lms.integration.service.CognitoHelper;
import com.trangile.lms.integration.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	CognitoHelper cognitoHelper;
	
	List<User> userList = new ArrayList<User>();
	
	public UserServiceImpl() {
		userList.add(new User("Sheetal","password","sheetal.bharara@trangile.com", "admin-support"));
		userList.add(new User("Abhishek","password","abhishek@trangile.com","admin-support"));
	}

	@Override
	public HashMap<String, Object> validateUser(User user) {
		return cognitoHelper.validateUser(user);
	}

	@Override
	public User getUser(String username) {
		for(User user :userList) {
			if(user.getUsername().equals(username)) {
				System.out.println("User match:::::::"+user.getUsername());
				return user;
			}
			
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		return this.userList;
	}

}
