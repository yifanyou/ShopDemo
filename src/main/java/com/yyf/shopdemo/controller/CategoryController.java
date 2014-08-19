package com.yyf.shopdemo.controller;

import com.yyf.shopdemo.dao.CategoryDao;
import com.yyf.shopdemo.domain.Category;
import com.yyf.shopdemo.domain.Customer;
import com.yyf.shopdemo.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 14-8-11.
 */
@Controller

public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @RequestMapping("/category")
    public ResponseEntity getProductsByCategoryName(){
        List<Category> list = categoryService.getCategory();
        return new ResponseEntity(list, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/category/{categoryName}")
    public String getCustomer(@PathVariable("categoryName") String categoryName, Model model){
        List<Category> categoryList = categoryService.getCategoryByName(categoryName);
        model.addAttribute(categoryList);
        return "category";
    }
}
