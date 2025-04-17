package com.ajihsu.springbootmall.dao;

import com.ajihsu.springbootmall.dto.OrderQueryParams;
import com.ajihsu.springbootmall.model.Order;
import com.ajihsu.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {
    Integer countOrder(OrderQueryParams orderQueryParams);
    List<Order> getOrders(OrderQueryParams orderQueryParams);
    Order getOrderById(Integer orderId);
    List<OrderItem> getOrderItemsByOrderId(Integer orderId);
    Integer createOrder(Integer userId, Integer totalAmount);
    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
    void deleteOrderByOrderId(Integer orderId);
    void deleteOrderItemsByOrderId(Integer orderId);
}
