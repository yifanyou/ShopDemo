package com.yyf.shopdemo.service;

import com.yyf.shopdemo.dao.CategoryDao;
import com.yyf.shopdemo.domain.Category;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 14-8-20.
 */
@Service
public class CategoryService {
    @Resource
    private CategoryDao categoryDao;

    public List<Category> getCategory(){
        Category category = new Category();
        return categoryDao.query(category);
    }

    public List<Category> getCategoryByName(String categoryName){
        Category category = new Category();
        category.setCategoryName(categoryName);

        return categoryDao.query(category);
    }
}
