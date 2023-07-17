package com.cart.service;

import java.util.List;

import com.cart.exception.CARTITEMALREADYEXISTS;
import com.cart.exception.CARTITEMNOTEXISTS;
import com.cart.model.Cart;

public interface ICartService {
	
	public Cart addToCart(Cart cObj) throws CARTITEMALREADYEXISTS;
	public Cart getCartItemById(int cartId) throws CARTITEMNOTEXISTS;
	public List<Cart> getAllCartItems();
	public boolean delCartById(int cartId) throws CARTITEMNOTEXISTS;
	public List<Cart> getByUserId(int userId)  throws CARTITEMNOTEXISTS;

}
