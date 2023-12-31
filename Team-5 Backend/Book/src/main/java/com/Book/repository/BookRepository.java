package com.Book.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Book.model.Book;

@Repository
public interface BookRepository  extends MongoRepository<Book,String> {
	   
	
	    List<Book> findBySellerId(int sellerId);
	    List<Book> findByBookNameRegexIgnoreCase(String pattern);
	    List<Book> findByCategory(String category);
	    List<Book> findByStatus(String status);
	    List<Book> findByCategoryAndStatus(String category, String status);
//	    sdklfjsdalfjasdklfjasdklfjsdlfjasdklfjsdlfjasdlfjsdklfjsdklfj
	    Page<Book> findByStatus(String status,PageRequest pageable);
	    
	    List<Book> findByBookNameLikeAndStatus(String bookNamePattern, String status);


	

}

