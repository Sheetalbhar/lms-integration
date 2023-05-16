package com.trangile.lms.integration.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trangile.lms.integration.model.User;
import com.trangile.lms.integration.service.UserService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	//get all users 
		@GetMapping("/all")
		public List<User> getAllUsers(){
			System.out.println("inside getAllUser");
			return this.userService.getAllUsers();
		}
		
		//get all users 
		@GetMapping("/{username}")
		public User getUser(@PathVariable String username) {
				return this.userService.getUser(username);
		}
			
		//validate users 
		@GetMapping("/validateUser")
		public HashMap<String, Object> validateUser(@RequestParam(value = "client_id") String clientId,
				@RequestParam(value = "username") String username,
				@RequestParam(value = "password") String password
				) {
				log.info("======================= validateUser api=========================");
				User user = new User(username, password, password, clientId);
					return this.userService.validateUser(user);
					}

}
