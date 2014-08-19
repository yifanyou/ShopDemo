package com.yyf.shopdemo.dao.impl;

import com.yyf.shopdemo.dao.ProductDao;
import com.yyf.shopdemo.domain.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 14-8-11.
 */
@Repository
public class ProductDaoImpl implements ProductDao{

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> query(Product product) {



        StringBuilder sql = new StringBuilder("select * from product where 1=1 ");

        if(product.getProductId()!=null&&!product.getProductId().equals(""))
            sql.append("and PRODUCT_ID = '" + product.getProductId() + "' ");
        if(product.getProductName()!=null&&!product.getProductName().equals(""))
            sql.append("and PRODUCT_NAME = '" + product.getProductName() + "' ");
        if(product.getCategoryName()!=null&&!product.getCategoryName().equals(""))
            sql.append("and CATEGORY_NAME = '" + product.getCategoryName() + "' ");
        if(product.getPrice()!=null&&!product.getPrice().equals(""))
            sql.append("and PRICE = '" + product.getPrice() + "' ");
        if(product.getNum()!=null&&!product.getNum().equals(""))
            sql.append("and NUM = '" + product.getNum() + "' ");
        if(product.getUrl()!=null&&!product.getUrl().equals(""))
            sql.append("and URL = '" + product.getUrl() + "' ");
        if(product.getStatus()!=null&&!product.getStatus().equals(""))
            sql.append("and STATUS = '" + product.getStatus() + "' ");
        if(product.getDescription()!=null&&!product.getDescription().equals(""))
            sql.append("and DESCRIPTION = '" + product.getDescription() + "' ");

        List<Product> list = jdbcTemplate.query(sql.toString(), new ProductRowMapper());
        return list;
    }

    @Override
    public Product queryByName(String productName) {
        String sql = "select * from product where PRODUCT_NAME = '" + productName + "'";
        Product product = (Product)jdbcTemplate.queryForObject(sql, new ProductRowMapper());
        return product;
    }

    @Override
    public void update(String productName) {

    }

    @Override
    public void insert(String productName) {

    }

    @Override
    public void delete(String productName) {

    }

    class ProductRowMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet rs, int i) throws SQLException {
            Product product = new Product();
            product.setProductId(rs.getString(2));
            product.setProductName(rs.getString(3));
            product.setCategoryName(rs.getString(4));
            product.setPrice(rs.getString(5));
            product.setNum(rs.getString(6));
            product.setUrl(rs.getString(7));
            product.setStatus(rs.getString(8));
            product.setDescription(rs.getString(9));
            return product;
        }
    }
}
