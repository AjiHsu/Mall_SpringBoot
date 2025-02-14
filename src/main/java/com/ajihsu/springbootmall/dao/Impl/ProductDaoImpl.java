package com.ajihsu.springbootmall.dao.Impl;

import com.ajihsu.springbootmall.dao.ProductDao;
import com.ajihsu.springbootmall.model.Product;
import com.ajihsu.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Product getProductById(Integer productId) {
        String sql = "SELECT product_id, product_name, category, image_url, price, stock, description," +
                "created_date, last_modified_date FROM product WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("productId", productId);

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
        
        return productList.size() > 0 ? productList.get(0) : null;
    }
}
