package com.ajihsu.springbootmall.dao;

import com.ajihsu.springbootmall.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);
}
