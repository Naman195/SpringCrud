package com.example.naman.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.naman.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
  Category findByName(String name); 
}
