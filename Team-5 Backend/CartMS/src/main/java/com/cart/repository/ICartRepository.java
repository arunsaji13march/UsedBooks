package com.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.model.Cart;


@Repository
public interface ICartRepository extends JpaRepository<Cart, Integer> {
	
	public List<Cart> findByUserId(int userId);

}
