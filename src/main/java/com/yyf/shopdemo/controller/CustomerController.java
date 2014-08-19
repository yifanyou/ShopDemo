package com.yyf.shopdemo.controller;

import com.yyf.shopdemo.dao.CustomerDao;
import com.yyf.shopdemo.domain.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 14-8-11.
 */
@Controller
public class CustomerController {
    @Resource
    private CustomerDao customerDao;

    @ModelAttribute("customerList")
    public List<Customer> populateCustomer(){
        List d = customerDao.query(new Customer());
        return d;
    }


//    @RequestMapping("/test")
//    public String show(){
//        return "test";
//    }
}
