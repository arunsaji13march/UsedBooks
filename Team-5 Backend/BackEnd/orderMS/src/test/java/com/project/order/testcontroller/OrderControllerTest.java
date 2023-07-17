package com.project.order.testcontroller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.order.controller.OrderController;
import com.project.order.model.OrderStatus;
import com.project.order.model.Orders;
import com.project.order.service.IOrderService;

public class OrderControllerTest {

    @Mock
    private IOrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddOrderHandler() {
        Orders mockOrder = new Orders();
        when(orderService.addOrder(any(Orders.class))).thenReturn(mockOrder);

        Orders requestOrder = new Orders();
        ResponseEntity<?> responseEntity = orderController.addOrderHandler(requestOrder);

        verify(orderService, times(1)).addOrder(requestOrder);
        Assertions.assertEquals(mockOrder, responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    public void testGetAllOrdersHandler() {
        List<Orders> mockOrders = new ArrayList<>();
        when(orderService.getAllOrders()).thenReturn(mockOrders);

        ResponseEntity<?> responseEntity = orderController.getAllOrdersHandler();

        verify(orderService, times(1)).getAllOrders();
        Assertions.assertEquals(mockOrders, responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testGetOrdersByUserIdHandler() {
        int userId = 1;
        List<Orders> mockOrders = new ArrayList<>();
        when(orderService.getOrdersByUserId(userId)).thenReturn(mockOrders);

        ResponseEntity<?> responseEntity = orderController.getUserByIdHandler(userId);

        verify(orderService, times(1)).getOrdersByUserId(userId);
        Assertions.assertEquals(mockOrders, responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testEditOrderStatusHandler() {
        int orderId = 1;
        Orders mockOrder = new Orders();
        when(orderService.editOrderStatus(any(Orders.class), eq(orderId))).thenReturn(mockOrder);

        Orders updateOrder = new Orders();
        ResponseEntity<?> responseEntity = orderController.editOrderStatusHandler(updateOrder, orderId);

        verify(orderService, times(1)).editOrderStatus(updateOrder, orderId);
        Assertions.assertEquals(mockOrder, responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testGetOrderByOrderIdHandler() {
        int orderId = 1;
        Orders mockOrder = new Orders();
        when(orderService.getOrderByOrderId(orderId)).thenReturn(mockOrder);

        ResponseEntity<?> responseEntity = orderController.getOrderByOrderIdHandler(orderId);

        verify(orderService, times(1)).getOrderByOrderId(orderId);
        Assertions.assertEquals(mockOrder, responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }



    @Test
    public void testGetAllOrdersHandler_ShouldReturnEmptyList_WhenNoOrdersExist() {
        when(orderService.getAllOrders()).thenReturn(new ArrayList<>());

        ResponseEntity<?> responseEntity = orderController.getAllOrdersHandler();

        verify(orderService, times(1)).getAllOrders();
        Assertions.assertEquals(new ArrayList<>(), responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }




}