package com.ajihsu.springbootmall.dao;

import com.ajihsu.springbootmall.dto.ProductQueryParams;
import com.ajihsu.springbootmall.dto.ProductRequest;
import com.ajihsu.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts(ProductQueryParams productQueryParams);
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
    void deleteProductById(Integer productId);
}
