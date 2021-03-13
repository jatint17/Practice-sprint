package com.cg.apps.customer.ui;

import com.cg.apps.customer.entities.*;
import com.cg.apps.customer.exceptions.*;
import com.cg.apps.customer.service.*;
import com.cg.apps.items.entities.Item;
import com.cg.apps.items.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CustomerUI 
{
    @Autowired
    private ICustomerService service ;
    @Autowired
    private IItemService itemService;

    public void start() 
    {
        try 
        {
            System.out.println("-------------------------\nITEMS");
            Item shoe = itemService.create(3999.9,"Sports Shoes");
            Item shirt = itemService.create(1299.9,"Formal Shirt");
            displayItem(shoe);
            displayItem(shirt);

            System.out.println("-------------------------\nCUSTOMERS");
            Customer shikhar = service.createCustomer("Shikhar");
            Customer ajinkya = service.createCustomer("Ajinkya");
            displayCustomer(shikhar);
            displayCustomer(ajinkya);

            Long id = shikhar.getId();
            Customer fetchedCustomer = service.findByID(id);
            System.out.println("-------------------------");
            System.out.println("Fetched Employee");
            displayCustomer(fetchedCustomer);

            Item item = itemService.buyItem(shoe.getId(), shikhar.getId());
            Set<Item> itemSet = shikhar.getBoughtItems();
            System.out.println("-------------------------\n");
            System.out.println(itemSet);
        }
        catch(InvalidIdException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catch(InvalidNameException e)
        {
           System.out.println(e.getMessage());
           e.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println("something went wrong!!");
            e.printStackTrace();
        }
    }

    public void displayCustomer(Customer customer)
    {
        System.out.println(customer.toString());
    }

    public void displayItem(Item item)
    {
        System.out.println(item.toString());
    }
}
