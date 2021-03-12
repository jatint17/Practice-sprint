package com.cg.apps.customer.ui;

import com.cg.apps.customer.entities.Customer;
import com.cg.apps.customer.exceptions.InvalidIdException;
import com.cg.apps.customer.service.ICustomerService;
import com.cg.apps.customer.exceptions.InvalidNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerUI {
    @Autowired
    private ICustomerService service ;


    public void start() {
        try {
            Customer shikhar = service.createCustomer("Shikhar");
            display(shikhar);
            Customer ajinkya = service.createCustomer("Ajinkya");
            display(ajinkya);

            Long id = shikhar.getId();
            Customer fetchedCustomer = service.findByID(id);

            System.out.println("-------------------------");
            System.out.println("Fetched Employee");
            display(fetchedCustomer);

        }catch(InvalidIdException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        catch(InvalidNameException e){
           System.out.println(e.getMessage());
           e.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println("something went wrong!!");
            e.printStackTrace();
        }

    }

    public void display(Customer customer){
        System.out.println(customer.toString());
    }


}
