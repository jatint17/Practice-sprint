package com.cg.apps.customer.util;

import com.cg.apps.customer.dto.CustomerDetails;
import com.cg.apps.customer.entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerUtil
{
    public CustomerDetails toDetail(Customer customer)
    {
        CustomerDetails customerDetails = new CustomerDetails(customer.getId(), customer.getName(),
                customer.getAccount().getAccountId(),customer.getAccount().getBalance());
        return customerDetails;
    }
}
