package com.yyf.shopdemo.dao.impl;

import com.yyf.shopdemo.dao.CategoryDao;
import com.yyf.shopdemo.domain.Category;
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
public class CategoryDaoImpl implements CategoryDao{

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> query(Category category) {
        String sql = "select * from category";
        List<Category> list = jdbcTemplate.query(sql, new CategoryRowMapper());
        return list;
    }

    @Override
    public Category queryByName(String categoryName) {
        String sql = "select * from customer where CATEGORY_NAME = '" + categoryName + "'";
        Category customer = (Category)jdbcTemplate.queryForObject(sql, new CategoryRowMapper());
        return customer;
    }

    @Override
    public void update(String categoryName) {

    }

    @Override
    public void insert(String categoryName) {

    }

    @Override
    public void delete(String categoryName) {

    }

    class CategoryRowMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet rs, int i) throws SQLException {
            Category category = new Category();
            category.setCategoryId(rs.getString(2));
            category.setCategoryName(rs.getString(3));
            category.setChildId(rs.getString(4));
            return category;
        }
    }
}
