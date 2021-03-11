package com.cg.apps.customermgt.customer.controller;

import com.cg.apps.customermgt.customer.bean.Customer;
import com.cg.apps.customermgt.customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/customers")
@RestController
public class CustomerRestController
{
    @Autowired
    private ICustomerService service;

    @GetMapping(value = "/bycustomerid/{id}")
    public Customer fetchCustomer(@PathVariable("id")Long customerId)
    {
        Customer customer = service.findByID(customerId);
        return customer;
    }
}
