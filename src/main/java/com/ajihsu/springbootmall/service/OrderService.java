package com.ajihsu.springbootmall.service;

import com.ajihsu.springbootmall.dto.CreateOrderRequest;
import com.ajihsu.springbootmall.dto.OrderQueryParams;
import com.ajihsu.springbootmall.model.Order;
import com.ajihsu.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderService {
    Integer countOrder(OrderQueryParams orderQueryParams);
    List<Order> getOrders(OrderQueryParams orderQueryParams);
    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
    void deleteOrder(Integer userId, Integer orderId);
}
