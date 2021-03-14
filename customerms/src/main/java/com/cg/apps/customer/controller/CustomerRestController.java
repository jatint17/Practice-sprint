package com.cg.apps.customer.controller;

import com.cg.apps.customer.dto.AddAmountRequest;
import com.cg.apps.customer.dto.CreateCustomerRequest;
import com.cg.apps.customer.dto.CustomerDetails;
import com.cg.apps.customer.dto.UpdateCustomerRequest;
import com.cg.apps.customer.entities.Customer;
import com.cg.apps.customer.service.ICustomerService;
import com.cg.apps.customer.util.CustomerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/customers")
@RestController
public class CustomerRestController
{
    @Autowired
    ICustomerService service;
    @Autowired
    CustomerUtil util;

    @GetMapping(value = "/bycustomerid/{id}")
    public CustomerDetails fetchCustomer(@PathVariable("id") Long id)
    {
        Customer customer = service.findByID(id);
        return util.toDetail(customer);
    }

    @PostMapping(value = "/add")
    public CustomerDetails addCustomer(@RequestBody CreateCustomerRequest createCustomerRequest)
    {
        Customer customer = service.createCustomer(createCustomerRequest.getName());
        return util.toDetail(customer);
    }

    @PutMapping(value = "/update")
    public CustomerDetails updateCustomer(@RequestBody UpdateCustomerRequest updateCustomerRequest)
    {
        Customer customer = service.update(updateCustomerRequest.getId(), updateCustomerRequest.getName());
        return util.toDetail(customer);
    }

    @PutMapping(value = "/addAmount")
    public CustomerDetails addAmount(@RequestBody AddAmountRequest addAmountRequest)
    {
        Customer customer = service.addAmount(addAmountRequest.getCustomerId(),addAmountRequest.getAmount());
        return util.toDetail(customer);
    }
}
