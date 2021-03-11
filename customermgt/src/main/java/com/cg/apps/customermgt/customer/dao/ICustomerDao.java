package com.cg.apps.customermgt.customer.dao;

import com.cg.apps.customermgt.customer.bean.Customer;

public interface ICustomerDao
{
    Customer add(Customer customer);
    Customer findByID(Long customerID);
    Customer update(Customer customer);
}