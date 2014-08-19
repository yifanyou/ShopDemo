package com.yyf.shopdemo.service;

import com.yyf.shopdemo.dao.ProductDao;
import com.yyf.shopdemo.domain.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 14-8-11.
 */
@Service
public class ProductService {
    @Resource
    private ProductDao productDao;

    public List<Product> getProductsByCategoryName(String categoryName){
        Product product = new Product();
        product.setCategoryName(categoryName);

        return productDao.query(product);
    }
}
