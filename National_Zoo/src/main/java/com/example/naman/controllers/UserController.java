package com.example.naman.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.example.naman.UserDTO.UserResponse;
import com.example.naman.entities.Credentials;
import com.example.naman.entities.User;
import com.example.naman.services.UserService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/zoo")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<?>  createUser(@RequestBody User user) {
		
		try {
	        userService.createUser(user);
	        return ResponseEntity.status(HttpStatus.CREATED).body("User SuccessFully Created");
	    } catch (Exception e) {
	        // Return a bad request or custom error message if something goes wrong
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User creation failed.");
	    }

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
	@CrossOrigin("http://localhost:3000")
	@PostMapping("/login")
	public UserResponse LoginUser(@RequestBody Credentials cred ){
		
		return userService.LoginUser(cred.getUsername(), cred.getPassword());
	}
	
	
	
	
}
