package com.cg.apps.customermgt.customer.service;

import com.cg.apps.customermgt.customer.bean.Customer;

public interface ICustomerService
{
    Customer findByID(Long customerID);
    Customer createCustomer(String name); //create customer and their account also here
}
