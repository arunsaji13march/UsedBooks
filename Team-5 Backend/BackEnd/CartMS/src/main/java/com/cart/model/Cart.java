package com.cart.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Cart {
	@Id
	@GeneratedValue
	private int cartId;
	private int userId;
	private String bookId;
	private String bookName;
	private double price;
	private String image;
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	public Cart() {
		super();
	}

	public Cart(int cartId, int userId, String bookId, String bookName, double price, String image,
			LocalDateTime createdAt) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.bookId = bookId;
		this.bookName = bookName;
		this.price = price;
		this.image = image;
		this.createdAt = createdAt;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", bookId=" + bookId + ", bookName=" + bookName
				+ ", price=" + price + ", image=" + image + ", createdAt=" + createdAt + "]";
	}
	
	
}
