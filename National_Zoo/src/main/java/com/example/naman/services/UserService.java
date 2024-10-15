package com.example.naman.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.naman.entities.Address;
import com.example.naman.entities.City;
import com.example.naman.entities.User;
import com.example.naman.repositories.CityRepository;
import com.example.naman.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CityRepository cityRepository;
	@Transactional
	public User createUser(User user) {
		City city = cityRepository.findById(user.getAddress().getCity().getCityId()).get();
		
		Address address = new Address();
		address.setStreet(user.getAddress().getStreet());
		address.setZipCode(user.getAddress().getZipCode());
		address.setCreatedBy(user.getAddress().getCreatedBy());
		address.setCity(city);
		user.setAddress(address);
		return userRepository.save(user);
	}
	
	
	public List<User> getAllUser(){
		List<User> users =  userRepository.findAll();
		List<User> filteredusers = 	users.stream().filter(user -> !user.getArchieved()).collect(Collectors.toList());
		return filteredusers;
		
	}
	
	public User getUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
		return user;
	}
	
	
//	public User deleteUserById(Long id) {
//		
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
