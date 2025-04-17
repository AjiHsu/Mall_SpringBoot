package com.ajihsu.springbootmall.dao;

import com.ajihsu.springbootmall.dto.ProductQueryParams;
import com.ajihsu.springbootmall.dto.ProductRequest;
import com.ajihsu.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {
    Integer countProducts(ProductQueryParams productQueryParams);
    List<Product> getProducts(ProductQueryParams productQueryParams);
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
    void updateStock(Integer productId, Integer stock);
    void deleteProductById(Integer productId);
}
