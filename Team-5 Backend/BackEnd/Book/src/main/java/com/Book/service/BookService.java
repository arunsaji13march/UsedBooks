package com.Book.service;

import java.util.List;

import com.Book.model.Book;

public interface BookService {
	public Book addBook(Book book);
	public Book updateBook(String bookId,Book updateBook);
	public List<Book> getAllBooks();
	public Book getBookById(String bookId);
	public boolean deleteBook(String bookId);
	
	public List<Book> getBooksBySellerId(int sellerId);
	
    public List<Book> searchBooksByName(String pattern);
    public List<Book> getBooksByCategory(String category);
    public List<Book> getBooksByCategoryAndStatus(String category, String status);
    

    
    public List<Book> getAllBooksStatus(String status);
	public List<Book> searchByNamePatternAndStatus(String bookNamePattern, String status);

	public Book editBookStatus(Book book, String bookId);

}
