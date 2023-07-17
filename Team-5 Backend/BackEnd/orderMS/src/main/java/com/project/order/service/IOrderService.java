package com.project.order.service;

import java.util.List;

import com.project.order.model.OrderStatus;
import com.project.order.model.Orders;

public interface IOrderService {
	
	public Orders addOrder(Orders oObj);
	public List<Orders> getAllOrders();
	public List<Orders> getOrdersByUserId(int userId);
	public Orders editOrderStatus(Orders newOrder, int orderId);
	public Orders getOrderByOrderId(int orderId);
	
	

}
