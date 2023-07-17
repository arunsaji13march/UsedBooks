package com.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.exception.CARTITEMALREADYEXISTS;
import com.cart.exception.CARTITEMNOTEXISTS;
import com.cart.model.Cart;
import com.cart.service.ICartService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/cart")
public class CartController {

	
	@Autowired
	private ICartService cartService;
	
	private ResponseEntity<?> responseEntity;
	
	@PostMapping("/addToCart")
	public ResponseEntity<?> saveItemHandler(@RequestBody Cart cObj) throws CARTITEMALREADYEXISTS
	{
		try
		{
		Cart newItem = this.cartService.addToCart(cObj);
		responseEntity = new ResponseEntity<>(newItem, HttpStatus.CREATED);
		}catch (CARTITEMALREADYEXISTS e) {
			responseEntity = new ResponseEntity<>("Cart Item  Already Exist", HttpStatus.CONFLICT);
					e.printStackTrace();	
		}
		return responseEntity;
	}
	
	
	@GetMapping("/getAllCartItems")
	public ResponseEntity<?> GetItemsHandler()
	{
		List<Cart> allItems = this.cartService.getAllCartItems();
		responseEntity = new ResponseEntity<>(allItems,HttpStatus.OK);
			return responseEntity;
	}
	
	
	
	@GetMapping("/getCartItemById/{cartId}")
	public ResponseEntity<?> getCartItemByIdHandler(@PathVariable int cartId) throws CARTITEMNOTEXISTS
	{
		try {
		Cart cObj = this.cartService.getCartItemById(cartId);
		responseEntity = new ResponseEntity<>(cObj, HttpStatus.OK);
		}catch(CARTITEMNOTEXISTS e) {
			responseEntity = new ResponseEntity("CartItem Not found", HttpStatus.NOT_FOUND);
		}
		return responseEntity;
		
	}
	
	@DeleteMapping("/delCartById/{cartId}")
	public ResponseEntity<?> DeleteCartItemByIdHandler(@PathVariable int cartId) throws CARTITEMNOTEXISTS
	{
		try {
		boolean status= this.cartService.delCartById(cartId);
		responseEntity = new ResponseEntity<>(status, HttpStatus.OK);
		}catch(CARTITEMNOTEXISTS e) {
			responseEntity = new ResponseEntity<>("Cart Item Not exist",HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	
	@GetMapping("/getByUserId/{userId}")
	public ResponseEntity<?>getByCartIdHandler(@PathVariable int userId) throws CARTITEMNOTEXISTS
	{
		try {
		List<Cart> cObj = this.cartService.getByUserId(userId);
		responseEntity = new ResponseEntity<>(cObj, HttpStatus.OK);
		}catch(CARTITEMNOTEXISTS e) {
			responseEntity = new ResponseEntity("CartItem Not found", HttpStatus.NOT_FOUND);
		}
		return responseEntity;
		
	}
	
	
	
}

