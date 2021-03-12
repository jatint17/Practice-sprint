package com.cg.apps.customer.dao;

import com.cg.apps.customer.entities.Customer;

import java.util.List;

public interface ICustomerDao {

    Customer add(Customer customer);
    Customer findByID(Long customerID);
    Customer update(Customer customer);
}
