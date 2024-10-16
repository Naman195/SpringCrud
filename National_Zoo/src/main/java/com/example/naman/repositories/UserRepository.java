package com.example.naman.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.naman.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByuserName(String username);

}
