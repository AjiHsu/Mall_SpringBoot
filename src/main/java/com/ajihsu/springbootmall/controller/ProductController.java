package com.ajihsu.springbootmall.controller;

import com.ajihsu.springbootmall.model.Product;
import com.ajihsu.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);

        return product != null ? ResponseEntity.status(HttpStatus.OK).body(product)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
