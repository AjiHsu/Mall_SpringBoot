package com.ajihsu.springbootmall.service;

import com.ajihsu.springbootmall.dto.CreateOrderRequest;
import com.ajihsu.springbootmall.model.Order;

public interface OrderService {
    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
