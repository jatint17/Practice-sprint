package com.cg.apps.customer.service;

import com.cg.apps.customer.entities.Customer;

public interface ICustomerService
{

    Customer findByID(Long customerID);
    Customer createCustomer(String name);
    Customer update(Long id,String name);


}
