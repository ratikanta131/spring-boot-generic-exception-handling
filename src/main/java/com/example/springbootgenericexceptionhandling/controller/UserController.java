package com.example.springbootgenericexceptionhandling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootgenericexceptionhandling.model.User;
import com.example.springbootgenericexceptionhandling.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("users/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUser(id);
	}

}
