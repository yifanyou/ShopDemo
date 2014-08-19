package com.yyf.shopdemo.dao.impl;

import com.yyf.shopdemo.dao.CustomerDao;
import com.yyf.shopdemo.domain.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 14-8-8.
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> query(Customer customer) {
        String sql = "select * from customer";
        List<Customer> list = jdbcTemplate.query(sql, new CustomerRowMapper());
        return list;
    }

    @Override
    public Customer queryById(String userId) {

        String sql = "select * from customer where USER_ID = '" + userId + "'";
        Customer customer = (Customer)jdbcTemplate.queryForObject(sql, new CustomerRowMapper());

        return customer;
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void insert(Customer customer) {

    }

    @Override
    public void delete(String username) {

    }

    class CustomerRowMapper implements org.springframework.jdbc.core.RowMapper {
        @Override
        public Object mapRow(ResultSet rs, int i) throws SQLException {
            Customer customer = new Customer();
            customer.setUserId(rs.getString(2));
            customer.setUserName(rs.getString(3));
            customer.setNickName(rs.getString(4));
            customer.setSex(rs.getString(5));
            customer.setBirthday(rs.getDate(6));
            customer.setPhone(rs.getString(7));
            return customer;
        }
    }
}
