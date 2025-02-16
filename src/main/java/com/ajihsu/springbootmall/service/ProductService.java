package com.ajihsu.springbootmall.service;

import com.ajihsu.springbootmall.dto.ProductRequest;
import com.ajihsu.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
}
