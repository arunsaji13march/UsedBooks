package com.project.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.order.model.OrderStatus;
import com.project.order.model.Orders;
import com.project.order.service.IOrderService;

@RestController
@CrossOrigin(origins="*",maxAge=5000)
@RequestMapping("/orders/api")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	private ResponseEntity<?> responseEntity;
	
	@PostMapping("/addOrder")
	public ResponseEntity<?> addOrderHandler(@RequestBody Orders oObj){
		Orders newOrder = this.orderService.addOrder(oObj);
		responseEntity = new ResponseEntity<>(newOrder,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/getAllOrder")
	public ResponseEntity<?> getAllOrdersHandler(){
		List<Orders> allOrders = this.orderService.getAllOrders();
		responseEntity = new ResponseEntity<>(allOrders,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/getOrdersById/{userId}")
	public ResponseEntity<?> getUserByIdHandler(@PathVariable int userId)
	{
		List<Orders> orders = this.orderService.getOrdersByUserId(userId);
		responseEntity = new ResponseEntity<>(orders,HttpStatus.OK);
		return responseEntity;
	}
	@PatchMapping("/editOrderStatus/{orderId}")
	public ResponseEntity<?> editOrderStatusHandler(@RequestBody Orders updateOrder, @PathVariable int orderId){
		Orders newOrder = this.orderService.editOrderStatus(updateOrder, orderId);
		responseEntity = new ResponseEntity<>(newOrder,HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping("/getOrderByOrderId/{orderId}")
	public ResponseEntity<?> getOrderByOrderIdHandler(@PathVariable int orderId){
		Orders orders = this.orderService.getOrderByOrderId(orderId);
		responseEntity = new ResponseEntity<>(orders,HttpStatus.OK);
		return responseEntity;
	}

}
