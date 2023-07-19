package com.Book.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Book {
	
	@Id
	private String bookId;
	private int sellerId;
	private String bookName;
	private Double price;
	private String authorName;
	private String bookDetails;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	String bookLanguage;
	String bookCondition;
	private String status;
	private String image;
	private String pickUpAddress;
	private String category;
//	boolean String Authorized;
	
	
	
	
	
	public String getBookId() {
		return bookId;
	}


	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", sellerId=" + sellerId + ", bookName=" + bookName + ", price=" + price
				+ ", authorName=" + authorName + ", bookDetails=" + bookDetails + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", bookLanguage=" + bookLanguage + ", bookCondition=" + bookCondition
				+ ", status=" + status + ", image=" + image + ", pickUpAddress=" + pickUpAddress + ", category="
				+ category + "]";
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public Book(String bookId, int sellerId, String bookName, Double price, String authorName, String bookDetails,
		LocalDateTime createdAt, LocalDateTime updatedAt, String bookLanguage, String bookCondition, String status,
		String image, String pickUpAddress, String category) {
	super();
	this.bookId = bookId;
	this.sellerId = sellerId;
	this.bookName = bookName;
	this.price = price;
	this.authorName = authorName;
	this.bookDetails = bookDetails;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
	this.bookLanguage = bookLanguage;
	this.bookCondition = bookCondition;
	this.status = status;
	this.image = image;
	this.pickUpAddress = pickUpAddress;
	this.category = category;
}


	public void setBookId(String bookId) {
		this.bookId = bookId;
	}


	public int getSellerId() {
		return sellerId;
	}


	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getAuthorName() {
		return authorName;
	}


	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	public String getBookDetails() {
		return bookDetails;
	}


	public void setBookDetails(String bookDetails) {
		this.bookDetails = bookDetails;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}


	public String getBookLanguage() {
		return bookLanguage;
	}


	public void setBookLanguage(String bookLanguage) {
		this.bookLanguage = bookLanguage;
	}


	public String getBookCondition() {
		return bookCondition;
	}


	public void setBookCondition(String bookCondition) {
		this.bookCondition = bookCondition;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getPickUpAddress() {
		return pickUpAddress;
	}


	public void setPickUpAddress(String pickUpAddress) {
		this.pickUpAddress = pickUpAddress;
	}


	
	
	
	

}
