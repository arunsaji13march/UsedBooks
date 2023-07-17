package com.project.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.order.model.Orders;

@Repository
public interface IOrderRepository extends JpaRepository<Orders, Integer> {
	List<Orders> findByUserId(int userId);
	Orders findByOrderId(int orderId);
}
