package com.cg.apps.customer.service;

import com.cg.apps.customer.entities.Customer;
import com.cg.apps.items.entities.Item;

import java.util.List;
import java.util.Set;

public interface ICustomerService
{

    Customer findByID(Long customerID);
    Customer createCustomer(String name);
    Customer update(Long id,String name);
    List<Customer> findAll();
//    List<Customer> findCustomerByName(String name);
    Set<Item> itemsBoughtByCustomer(Long customerID);
    public Customer addAmount(long customerId, double amount);
}
