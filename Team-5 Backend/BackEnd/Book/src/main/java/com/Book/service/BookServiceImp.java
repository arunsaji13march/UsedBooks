package com.Book.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Book.model.Book;
import com.Book.repository.BookRepository;


@Service
public class BookServiceImp implements BookService {

	@Autowired
	BookRepository bookRepository;
	
	

	@Override
	public Book updateBook(String bookId, Book updatedBook) {
		// TODO Auto-generated method stub
		  Optional<Book> optional= this.bookRepository.findById(bookId);
		  Book existingBook=optional.get();
		  
		  LocalDateTime currentDateTime = LocalDateTime.now();
		  existingBook.setUpdatedAt(currentDateTime);
		  
		  if (updatedBook.getBookId() != null) {
	            existingBook.setBookId(updatedBook.getBookId());
	        }
		  
		  if (updatedBook.getBookName() != null) {
	            existingBook.setBookName(updatedBook.getBookName());
	        }
	        if (updatedBook.getPrice() != null) {
	            existingBook.setPrice(updatedBook.getPrice());
	        }
	        if (updatedBook.getAuthorName() != null) {
	            existingBook.setAuthorName(updatedBook.getAuthorName());
	        }
	        if (updatedBook.getBookDetails() != null) {
	            existingBook.setBookDetails(updatedBook.getBookDetails());
	        }
	        if (updatedBook.getBookCondition() != null) {
	            existingBook.setBookCondition(updatedBook.getBookCondition());
	        }
	        if (updatedBook.getStatus() != null) {
	            existingBook.setStatus(updatedBook.getStatus());
	        }
	        if (updatedBook.getImage() != null) {
	            existingBook.setImage(updatedBook.getImage());
	        }
	        if (updatedBook.getPickUpAddress() != null) {
	            existingBook.setPickUpAddress(updatedBook.getPickUpAddress());
	        }
	        if (updatedBook.getCategory() != null) {
	            existingBook.setCategory(updatedBook.getCategory());
	        }
	        
	         this.bookRepository.save(existingBook);
	        
		  
		return existingBook;
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		List<Book> bookList=this.bookRepository.findByStatus("Available");
		return bookList;
	}

	@Override
	public Book getBookById(String bookId) {
		// TODO Auto-generated method 
		System.out.println("Get book by Id");
		Optional<Book> optional=this.bookRepository.findById(bookId);
		Book book=optional.get();
		return book;
	}

	@Override
	public boolean deleteBook(String bookId) {
		// TODO Auto-generated method stub
		Optional<Book> optional=this.bookRepository.findById(bookId);
		if(optional.isPresent()) {
			this.bookRepository.delete(optional.get());
			return true;
		}
		return false;
	}

	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		  LocalDateTime currentDateTime = LocalDateTime.now();
	        book.setCreatedAt(currentDateTime);
	        System.out.println(book.getCreatedAt());
	        book.setUpdatedAt(currentDateTime);
	        System.out.print(book);
		return this.bookRepository.insert(book);
	}

	@Override
	public List<Book> getBooksBySellerId(int sellerId) {
		// TODO Auto-generated method stub
		List<Book> optional=this.bookRepository.findBySellerId(sellerId); 
		return optional;
	}
	
    public List<Book> searchBooksByName(String pattern) {
        return bookRepository.findByBookNameRegexIgnoreCase(pattern);
    }
    
    public List<Book> getBooksByCategory(String category){
    	return this.bookRepository.findByCategory(category);
    }

	@Override
	public List<Book> getAllBooksStatus(String status) {
		// TODO Auto-generated method stub
		List<Book> bookList=this.bookRepository.findByStatus(status);
		return bookList;
	}	

	@Override
	public List<Book> getBooksByCategoryAndStatus(String category, String status) {
		// TODO Auto-generated method stub
		List<Book> bookList=this.bookRepository.findByCategoryAndStatus(category, status);

		return bookList;
	}

	@Override
	public List<Book> searchByNamePatternAndStatus(String bookNamePattern, String status) {
		// TODO Auto-generated method stub
		return this.bookRepository.findByBookNameLikeAndStatus(bookNamePattern, status);
	}

	@Override
	public Book editBookStatus(Book book, String bookId) {
		Optional<Book> optional = this.bookRepository.findById(bookId);
		 Book UpdatedBook = null;
		Book updatedOrderStatus = null;
		if(optional.isPresent()) {
			UpdatedBook = optional.get();
			UpdatedBook.setStatus(book.getStatus());
			updatedOrderStatus = this.bookRepository.save(UpdatedBook);
		}
		return updatedOrderStatus;
	}
	
	

	


}
