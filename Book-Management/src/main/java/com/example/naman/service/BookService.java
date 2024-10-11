package com.example.naman.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.naman.entity.Book;
import com.example.naman.entity.Category;
import com.example.naman.repository.BookRepository;
import com.example.naman.repository.CategoryRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository ;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public Book saveBook(Book book) {
		Category category = categoryRepository.findByName(book.getCategory().getName());
		System.out.println(category);
		

		Book bk = new Book();
		bk.setCategory(category);
		bk.setTitle(book.getTitle());
		bk.setAuthor(book.getAuthor());
		bk.setPrice(book.getPrice());
		return  bookRepository.save(bk);
	}
	
	
	public  List<Book> getAllBooks(){
		
		List<Book> books = bookRepository.findAll();
		return books;
		
	}
	
	
	public Book  getBookById(Long id) {
		Book book = bookRepository.findById(id).orElse(null);
		return book;
	}
	
	public Book updateBookById(Long id, Book book) {
		Book existedBook = bookRepository.findById(id).orElse(null);
		if(existedBook !=  null) {
			existedBook.setTitle(book.getTitle());
			existedBook.setAuthor(book.getAuthor());
			existedBook.setPrice(book.getPrice());
			Category category = categoryRepository.findByName(book.getCategory().getName());
			
			existedBook.setCategory(category);
			
			
			
			return bookRepository.save(existedBook);
		}
		return null;

	}
	
	
	public void deleteBookById(Long id) {
		bookRepository.deleteById(id);
	}
	
	
	public List<Book> getBookByAuthor(String name){
		List<Book> books = bookRepository.findByAuthor(name);
		return books;
			
		
	}
	
	
	
	
 }
