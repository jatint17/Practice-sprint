package com.cg.apps.customer.ui;

import com.cg.apps.customer.entities.*;
import com.cg.apps.customer.exceptions.*;
import com.cg.apps.customer.service.*;
import com.cg.apps.items.entities.Item;
import com.cg.apps.items.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
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
            shikhar = service.addAmount(shikhar.getId(),21000.0);
            ajinkya = service.addAmount(ajinkya.getId(),17560.5);
            displayCustomer(shikhar);
            displayCustomer(ajinkya);

            Long id = shikhar.getId();
            Customer fetchedCustomer = service.findByID(id);
            System.out.println("-------------------------");
            System.out.println("Fetched Employee");
            displayCustomer(fetchedCustomer);

            System.out.println("-------------------------\nITEMS BOUGHT");
            Item item1 = itemService.buyItem(shoe.getId(),shikhar.getId());
            Item item2 = itemService.buyItem(shirt.getId(),shikhar.getId());

            System.out.println("Item *"+item1.getDescription()+"* bought by "+item1.getBoughtBy().getName());
            System.out.println("Item *"+item2.getDescription()+"* bought by "+item2.getBoughtBy().getName());

            Set<Item> items = service.itemsBoughtByCustomer(shikhar.getId());
            System.out.println("Items Bought by "+shikhar.getName()+":");
            items.stream().map(x->x.getDescription()).forEach(System.out::println);
            System.out.println("Balance left for "+shikhar.getName()+" is: "+shikhar.getAccount().getBalance());

            System.out.println("-------------------------\nALL CUSTOMERS");
            List<Customer> customers = service.findAll();
            for(Customer customer:customers)
            {
                System.out.println(customer.getId() + " - " + customer.getName());
            }
//            List<Customer> customers = service.findCustomerByName(shikhar.getName());
//            for(Customer customer : customers)
//            {
//                displayCustomer(customer);
//            }

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
