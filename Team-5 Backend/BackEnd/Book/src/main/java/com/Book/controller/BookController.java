package com.Book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Book.model.Book;
import com.Book.service.BookService;


import ch.qos.logback.core.status.Status;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableFeignClients
@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("books/v1")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	ResponseEntity<?> responseEntity;
	
	@GetMapping("/getAllBooks")
		public ResponseEntity<?> getUserHandler(){
		List<Book> bookList = this.bookService.getAllBooks();
		responseEntity = new ResponseEntity<>(bookList,HttpStatus.OK);
		return responseEntity.ok(bookList);
	}	
	@PostMapping("/updateBook/{bookId}")
	public ResponseEntity<?> updateBookHandler(@RequestBody Book book,@PathVariable String bookId){
		Book book1=bookService.updateBook(bookId, book);
		responseEntity=new ResponseEntity<>(book1,HttpStatus.CREATED);
		return responseEntity;
		
	}
	
	
	@PostMapping("/addBook")
	public ResponseEntity<Book> addBookHandler(@RequestBody Book book){
		Book newBooks=this.bookService.addBook(book);
		return responseEntity.ok(book);	
		
	}
	
	
    
    
    @GetMapping("/getBooksById/{bookId}")
    public ResponseEntity<Book> getBooksByIdHandler(@PathVariable String bookId) {
        Book books = bookService.getBookById(bookId);
        return ResponseEntity.ok(books);
    }
    
    
    
    @DeleteMapping("/deleteBooks/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable String bookId) {
        boolean deleted = bookService.deleteBook(bookId);
        System.out.print(deleted);
        if (deleted) {
            return ResponseEntity.ok().body("Deletion Sucessful");
        } else {
            return ResponseEntity.notFound().build();
        }
    }	

    @GetMapping("/getBooksByStatus")
    public ResponseEntity<List<Book>> getBooksByStatusHandler(@RequestParam String status) {
        List<Book> books = this.bookService.getAllBooksStatus(status);
        return ResponseEntity.ok(books);	
    }
    
    @GetMapping("/getBooksByCategoryAndStatus")
    public ResponseEntity<List<Book>> getBooksByStatusAndCategoryHandler(@RequestParam String status, @RequestParam String category) {
        List<Book> books = this.bookService.getBooksByCategoryAndStatus(category, status);
        return ResponseEntity.ok(books);	
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getBooksByUserId(@PathVariable int userId) {
        List<Book> books = bookService.getBooksBySellerId(userId);
        
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(books);
        }
    }
    
    @GetMapping("/search")
    public List<Book> searchBooksByName(@RequestParam String pattern) {
        return bookService.searchBooksByName(pattern);
    }
    
    @GetMapping("/searchbyNameAndStatus")
    public ResponseEntity<List<Book>> searchBooksByNamePatternAndStatus(@RequestParam String name,@RequestParam String status
    ) {
        List<Book> books = bookService.searchByNamePatternAndStatus(name, status);
        return ResponseEntity.ok(books);
    }
    
    @GetMapping("/category")
    public List<Book> getByCategoryHandler(@RequestParam String category){
    	 return this.bookService.getBooksByCategory(category);	

    }	
    
    @PatchMapping("/updateBookStatus/{bookId}")
	public ResponseEntity<?> editOrderStatusHandler(@RequestBody Book updatedBook, @PathVariable String bookId){
		Book book = this.bookService.editBookStatus(updatedBook, bookId);
		responseEntity = new ResponseEntity<>(book,HttpStatus.OK);
		return responseEntity;
	}


}
