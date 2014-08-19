package com.yyf.shopdemo.controller;

import com.yyf.shopdemo.dao.CategoryDao;
import com.yyf.shopdemo.domain.Category;
import com.yyf.shopdemo.domain.Customer;
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
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryDao categoryDao;

    @RequestMapping("/")
    public ResponseEntity getProductsByCategoryName(){
        List<Category> list = productService.getProductsByCategoryName("面包");
        return new ResponseEntity(list, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{categoryName}")
    public String getCustomer(@PathVariable("categoryName") String categoryName, Model model){
        Category category = categoryDao.queryByName(categoryName);
        model.addAttribute(category);
        return "category";
    }
}
