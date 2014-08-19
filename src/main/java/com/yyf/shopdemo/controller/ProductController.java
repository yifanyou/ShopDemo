package com.yyf.shopdemo.controller;

import com.yyf.shopdemo.domain.Product;
import com.yyf.shopdemo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 14-8-11.
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;

//    @ModelAttribute("productList")
//    public List<Product> populateProduct(){
//        return productService.getProductsByCategoryName("面包");
//    }

    @RequestMapping("/test")
    public String show(){
        return "test";
    }

    @RequestMapping(value="/{categoryName}", method= RequestMethod.GET)
    public ResponseEntity getProductsByCategoryName(@PathVariable("categoryName") String categoryName){
        List<Product> list = productService.getProductsByCategoryName("面包");
        return new ResponseEntity(list, HttpStatus.CREATED);
    }
}
