package com.project.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.order.model.OrderStatus;
import com.project.order.model.Orders;
import com.project.order.repository.IOrderRepository;

@Service
public class OrderService implements IOrderService {
	
	@Autowired
	private IOrderRepository orderRepository;


	@Override
	public Orders addOrder(Orders oObj) {
		Orders newOrder = this.orderRepository.save(oObj);
		return newOrder;
		
	}

	@Override
	public List<Orders> getAllOrders() {
		return this.orderRepository.findAll();
	}

	@Override
	public List<Orders> getOrdersByUserId(int userId) {
		List<Orders> ordersByUserId = this.orderRepository.findByUserId(userId);
		return ordersByUserId;
	}

	@Override
	public Orders editOrderStatus(Orders newOrder, int orderId) {
		Optional<Orders> optional = this.orderRepository.findById(orderId);
		Orders updatedObj = null;
		Orders updatedOrderStatus = null;
		if(optional.isPresent()) {
			updatedObj = optional.get();
			updatedObj.setOrderStatus(newOrder.getOrderStatus());
			updatedOrderStatus = this.orderRepository.save(updatedObj);
		}
		return updatedOrderStatus;
	}

	@Override
	public Orders getOrderByOrderId(int orderId) {
		Orders order = this.orderRepository.findByOrderId(orderId);
		return order;
	}
	
	
	

}
