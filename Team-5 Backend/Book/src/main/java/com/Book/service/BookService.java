package com.Book.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Book.model.Book;

public interface BookService {
	public Book addBook(Book book);
	public Book updateBook(String bookId,Book updateBook);
	public Page<Book> getAllBooks(int page, int size);
	public Book getBookById(String bookId);
	public boolean deleteBook(String bookId);
	
	public List<Book> getBooksBySellerId(int sellerId);
	
    public List<Book> searchBooksByName(String pattern);
    public List<Book> getBooksByCategory(String category);
    public List<Book> getBooksByCategoryAndStatus(String category, String status);
    

    
    public List<Book> getAllBooksStatus(String status);
    public Page<Book> getAllBooksStatusPage(int page,int size, String status);
	public List<Book> searchByNamePatternAndStatus(String bookNamePattern, String status);

	public Book editBookStatus(Book book, String bookId);

}
