package com.example.naman.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.naman.entities.Credentials;
import com.example.naman.entities.User;
import com.example.naman.services.UserService;

@RestController
@RequestMapping("/api/zoo")
public class UserController {

	@Autowired
	private UserService userService;
	
	@CrossOrigin("http://localhost:3000")
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);	
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		return userService.getAllUser();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Long id)
	{
		User user =  userService.getUserById(id);
		if(user.isArchieved()) {
			return ResponseEntity.status(404).body("User NOt Found");
		}
		return ResponseEntity.ok().body(user);
	}
	
	
	@PutMapping("/update/{id}")
	public User updateUserById(@RequestBody User user, @PathVariable Long id)
	{
		return userService.UpdateUserById(user, id);
	}
	
	@PatchMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
		return "User Deleted SuccessFully";
	}
	
	@PostMapping("/login")
	public String LoginUser(@RequestBody Credentials cred ){
		
		String user = userService.LoginUser(cred.getUsername(), cred.getPassword());
		return user;
	}
	
	
	
	
}
