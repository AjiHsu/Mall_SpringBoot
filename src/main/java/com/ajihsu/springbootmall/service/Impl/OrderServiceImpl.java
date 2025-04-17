package com.ajihsu.springbootmall.service.Impl;

import com.ajihsu.springbootmall.dao.OrderDao;
import com.ajihsu.springbootmall.dao.ProductDao;
import com.ajihsu.springbootmall.dao.UserDao;
import com.ajihsu.springbootmall.dto.CreateOrderRequest;
import com.ajihsu.springbootmall.model.Order;
import com.ajihsu.springbootmall.model.OrderItem;
import com.ajihsu.springbootmall.model.Product;
import com.ajihsu.springbootmall.model.User;
import com.ajihsu.springbootmall.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {
    private final static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Order getOrderById(Integer orderId) {
        Order order = orderDao.getOrderById(orderId);

        List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(orderId);
        order.setOrderItemList(orderItemList);

        return order;
    }

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        // check the existence of user
        User user = userDao.getUserById(userId);
        if (user == null) {
            log.warn("the userId {} is not exist", userId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>() ;

        for (var buyItem : createOrderRequest.getBuyItemList()) {

            Product product = productDao.getProductById(buyItem.getProductId());

            // check the existence of the product and if it has enough stock
            if (product == null) {
                log.warn("the product {} not exists", buyItem.getProductId());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            } else if (product.getStock() < buyItem.getQuantity()) {
                log.warn("the product {} doesn't has enough stock. remaining: {}, request: {}",
                        buyItem.getProductId(), product.getStock(), buyItem.getQuantity());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

            // stock -= quantity
            productDao.updateStock(product.getProductId(), product.getStock() - buyItem.getQuantity());

            // calculate total amount
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount += amount;

            // buyItem --> orderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }


        // create order
        Integer orderId = orderDao.createOrder(userId, totalAmount);
        orderDao.createOrderItems(orderId, orderItemList);

        return orderId;
    }
}
