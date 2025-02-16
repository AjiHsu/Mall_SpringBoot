package com.ajihsu.springbootmall.dao;

import com.ajihsu.springbootmall.dto.ProductRequest;
import com.ajihsu.springbootmall.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
}
