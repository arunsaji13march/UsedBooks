package com.Book.testcontroller;

import com.Book.controller.BookController;
import com.Book.model.Book;
import com.Book.service.BookService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllBooks() {
        // Arrange
        List<Book> mockBookList = new ArrayList<>();
        // Add some mock books to the list

        when(bookService.getAllBooks()).thenReturn(mockBookList);

        // Act
        ResponseEntity<?> responseEntity = bookController.getUserHandler();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockBookList, responseEntity.getBody());
    }

    @Test
    public void testUpdateBookHandler() {
        // Arrange
        String bookId = "123";
        Book mockBook = new Book();
        // Set properties of the mock book

        when(bookService.updateBook(eq(bookId), any(Book.class))).thenReturn(mockBook);

        // Act
        ResponseEntity<?> responseEntity = bookController.updateBookHandler(mockBook, bookId);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(mockBook, responseEntity.getBody());
    }

    @Test
    public void testAddBookHandler() {
        // Arrange
        Book mockBook = new Book();
        // Set properties of the mock book

        when(bookService.addBook(any(Book.class))).thenReturn(mockBook);

        // Act
        ResponseEntity<Book> responseEntity = bookController.addBookHandler(mockBook);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockBook, responseEntity.getBody());
    }

    @Test
    public void testGetBooksByIdHandler() {
        // Arrange
        String bookId = "123";
        Book mockBook = new Book();
        // Set properties of the mock book

        when(bookService.getBookById(bookId)).thenReturn(mockBook);

        // Act
        ResponseEntity<Book> responseEntity = bookController.getBooksByIdHandler(bookId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockBook, responseEntity.getBody());
    }

    @Test
    public void testDeleteBook() {
        // Arrange
        String bookId = "123";
        when(bookService.deleteBook(bookId)).thenReturn(true);

        // Act
        ResponseEntity<?> responseEntity = bookController.deleteBook(bookId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Deletion Sucessful", responseEntity.getBody());
    }

    @Test
    public void testGetBooksByStatusHandler() {
        // Arrange
        String status = "available";
        List<Book> mockBookList = new ArrayList<>();
        // Add some mock books to the list

        when(bookService.getAllBooksStatus(status)).thenReturn(mockBookList);

        // Act
        ResponseEntity<List<Book>> responseEntity = bookController.getBooksByStatusHandler(status);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockBookList, responseEntity.getBody());
    }

    @Test
    public void testGetBooksByStatusAndCategoryHandler() {
        // Arrange
        String status = "available";
        String category = "fiction";
        List<Book> mockBookList = new ArrayList<>();
        // Add some mock books to the list

        when(bookService.getBooksByCategoryAndStatus(category, status)).thenReturn(mockBookList);

        // Act
        ResponseEntity<List<Book>> responseEntity = bookController.getBooksByStatusAndCategoryHandler(status, category);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockBookList, responseEntity.getBody());
    }

    @Test
    public void testSearchBooksByName() {
        // Arrange
        String pattern = "Harry Potter";
        List<Book> mockBookList = new ArrayList<>();
        // Add some mock books to the list

        when(bookService.searchBooksByName(pattern)).thenReturn(mockBookList);

        // Act
        List<Book> result = bookController.searchBooksByName(pattern);

        // Assert
        assertEquals(mockBookList, result);
    }

    @Test
    public void testSearchBooksByNamePatternAndStatus() {
        // Arrange
        String name = "Harry Potter";
        String status = "available";
        List<Book> mockBookList = new ArrayList<>();
        // Add some mock books to the list

        when(bookService.searchByNamePatternAndStatus(name, status)).thenReturn(mockBookList);

        // Act
        ResponseEntity<List<Book>> responseEntity = bookController.searchBooksByNamePatternAndStatus(name, status);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockBookList, responseEntity.getBody());
    }

    @Test
    public void testGetByCategoryHandler() {
        // Arrange
        String category = "fiction";
        List<Book> mockBookList = new ArrayList<>();
        // Add some mock books to the list

        when(bookService.getBooksByCategory(category)).thenReturn(mockBookList);

        // Act
        List<Book> result = bookController.getByCategoryHandler(category);

        // Assert
        assertEquals(mockBookList, result);
    }
}