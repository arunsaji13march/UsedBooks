package com.cart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.exception.CARTITEMALREADYEXISTS;
import com.cart.exception.CARTITEMNOTEXISTS;
import com.cart.model.Cart;
import com.cart.repository.ICartRepository;


@Service
public class CartServiceImpl implements ICartService {
	
	
	@Autowired
	private ICartRepository cartRepository;

	@Override
	public Cart addToCart(Cart cObj) throws CARTITEMALREADYEXISTS {
		Cart additem = null;
		Optional<Cart> cartitem = this.cartRepository.findById(cObj.getCartId());
		if(cartitem.isPresent())
		{
			throw new CARTITEMALREADYEXISTS();
		}
		else {
			additem = this.cartRepository.save(cObj);
			
		}
		return cObj;
	}

	
	
	@Override
	public Cart getCartItemById(int cartId) throws CARTITEMNOTEXISTS {
		Optional <Cart> cartItem = this.cartRepository.findById(cartId);
		Cart uObj = null;
		
		if(cartItem.isPresent())
		{
			uObj =cartItem.get();
		}
		else
		{
			throw new  CARTITEMNOTEXISTS();
		}
		
		return uObj;
	}
	
	

	@Override
	public List<Cart> getAllCartItems() {
		return this.cartRepository.findAll();
	}
	
	

	@Override
	public boolean delCartById(int cartId) throws CARTITEMNOTEXISTS {
		Optional <Cart> cartItem = this.cartRepository.findById(cartId);
		boolean  status = false;
		if(cartItem.isPresent())
		{
			this.cartRepository.delete(cartItem.get());
			status = true;	
		}
		else
		{
			throw new CARTITEMNOTEXISTS();
		}
		return status;
	}



	@Override
	public List<Cart> getByUserId(int userId)  throws CARTITEMNOTEXISTS{
		List<Cart> cartItems = this.cartRepository.findByUserId(userId);
		if(cartItems!=null)
			{
			return cartItems;
			}
		else {
			throw new CARTITEMNOTEXISTS();
		}
	
	}

}
