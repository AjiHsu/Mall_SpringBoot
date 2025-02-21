package com.ajihsu.springbootmall.dao;

import com.ajihsu.springbootmall.constant.ProductCategory;
import com.ajihsu.springbootmall.dto.ProductRequest;
import com.ajihsu.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts(ProductCategory category, String search);
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
    void deleteProductById(Integer productId);
}
