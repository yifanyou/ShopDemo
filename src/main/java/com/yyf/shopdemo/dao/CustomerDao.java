package com.yyf.shopdemo.dao;

import com.yyf.shopdemo.domain.Customer;

import java.util.List;

/**
 * Created by Administrator on 14-8-8.
 */
public interface CustomerDao {

    public List<Customer> query(Customer customer);

    public Customer queryById(String userId);

    public void update(Customer customer);

    public void insert(Customer customer);

    public void delete(String username);

}
