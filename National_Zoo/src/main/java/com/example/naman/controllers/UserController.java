package com.example.naman.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.naman.entities.User;
import com.example.naman.services.UserService;

@RestController
@RequestMapping("/api/zoo")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);	
	}
	
	@GetMapping("users")
	public List<User> getAllUsers()
	{
		return userService.getAllUser();
	}
	
	@GetMapping("users/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Long id)
	{
		User user =  userService.getUserById(id);
		if(user.getArchieved()) {
			return ResponseEntity.status(404).body("User NOt Found");
		}
		return ResponseEntity.ok().body(user);
	}
	
}
