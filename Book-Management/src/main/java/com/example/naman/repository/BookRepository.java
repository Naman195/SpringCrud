package com.example.naman.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.naman.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	List<Book> findByAuthor(String name);
	
	

}
