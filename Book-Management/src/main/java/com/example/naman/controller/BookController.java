package com.example.naman.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.naman.entity.Book;
import com.example.naman.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/add")
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id){
		return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> books =  bookService.getAllBooks();
		return new ResponseEntity<>(books	, HttpStatus.OK);
	}
	
    @CrossOrigin("http://localhost:3000")
	@GetMapping("/author/{name}")
	public ResponseEntity<List<Book>> getBookByAuthor(@PathVariable String name){
		List<Book> books = bookService.getBookByAuthor(name);
		return new ResponseEntity<>(books, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Book> updateBookById(@PathVariable Long id, @RequestBody Book book){
		Book Updatedbook = bookService.updateBookById(id, book);
		if(Updatedbook != null) {
			return new ResponseEntity<>(Updatedbook, HttpStatus.OK);
		} else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
}


	@DeleteMapping("/del/{id}")
	public ResponseEntity<Void> deleteBookById(@PathVariable Long id){
		bookService.deleteBookById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	

	

}
