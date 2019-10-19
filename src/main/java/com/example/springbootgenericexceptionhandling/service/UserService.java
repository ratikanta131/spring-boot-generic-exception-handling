package com.example.springbootgenericexceptionhandling.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.springbootgenericexceptionhandling.model.User;

@Component
public class UserService {
	
	public static List<User> users = new ArrayList<>();
	
	static {
	
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Eve", new Date()));
		users.add(new User(3, "Jack", new Date()));
	}

	public User getUser(int id) {
		
		List<User> userList = users.stream().filter(user->user.getId() == id).collect(Collectors.toList());
		if(userList.size() > 0)
			return userList.get(0);
		else
			return null;
	}
	
	

}
