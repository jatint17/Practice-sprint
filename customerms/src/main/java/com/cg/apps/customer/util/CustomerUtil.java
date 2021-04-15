package com.cg.apps.customer.util;

import com.cg.apps.customer.dto.CustomerDetails;
import com.cg.apps.customer.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerUtil
{
    public CustomerDetails toDetail(Customer customer)
    {
        CustomerDetails customerDetails = new CustomerDetails(customer.getId(), customer.getName(),
                customer.getAccount().getAccountId(),customer.getAccount().getBalance());
        return customerDetails;
    }

    public List<CustomerDetails> toDetails(List<Customer> customers)
    {
        List<CustomerDetails> customerDetails = new ArrayList<>();
        for(Customer customer:customers)
        {
            CustomerDetails details = toDetail(customer);
            customerDetails.add(details);
        }
        return customerDetails;
    }
}
