package com.cg.apps.customermgt.customer.ui;

import com.cg.apps.customermgt.customer.bean.Customer;
import com.cg.apps.customermgt.customer.exception.InvalidIdException;
import com.cg.apps.customermgt.customer.exception.InvalidNameException;
import com.cg.apps.customermgt.customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerUI
{
    @Autowired
    private ICustomerService service;

    public void start()
    {
        try
        {
            //adding customer
            Customer shikhar = service.createCustomer("Shikhar");
            Customer ajinkya = service.createCustomer("Ajinkya");
            display(shikhar);
            display(ajinkya);

            Long id = shikhar.getCustId();
            Customer fetchedCustomer = service.findByID(id);
            display(fetchedCustomer);
        }
        catch (InvalidIdException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catch (InvalidNameException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong!");
            e.printStackTrace();
        }
    }
    public void display(Customer customer)
    {
        System.out.println(customer.toString());
    }
}
