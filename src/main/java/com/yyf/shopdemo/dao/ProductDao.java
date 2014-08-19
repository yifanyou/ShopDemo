package com.yyf.shopdemo.dao;

import com.yyf.shopdemo.domain.Product;

import java.util.List;

/**
 * Created by Administrator on 14-8-11.
 */
public interface ProductDao {

    public List<Product> query(Product product);

    public Product queryByName(String productName);

    public void update(String productName);

    public void insert(String productName);

    public void delete(String productName);

}
