package com.yyf.shopdemo.dao;

import com.yyf.shopdemo.domain.Category;

import java.util.List;

/**
 * Created by Administrator on 14-8-11.
 */
public interface CategoryDao {

    public List<Category> query(Category category);

    public Category queryByName(String categoryName);

    public void update(String categoryName);

    public void insert(String categoryName);

    public void delete(String categoryName);

}
