package com.ajihsu.springbootmall.rowmapper;

import com.ajihsu.springbootmall.model.OrderItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderItemRowMapper implements RowMapper<OrderItem> {

    @Override
    public OrderItem mapRow(ResultSet result, int i) throws SQLException {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderItemId(result.getInt("order_item_id"));
        orderItem.setOrderId(result.getInt("order_id"));
        orderItem.setProductId(result.getInt("product_id"));
        orderItem.setQuantity(result.getInt("quantity"));
        orderItem.setAmount(result.getInt("amount"));

        orderItem.setProductName(result.getString("product_name"));
        orderItem.setImageUrl(result.getString("image_url"));
        return orderItem;
    }
}
