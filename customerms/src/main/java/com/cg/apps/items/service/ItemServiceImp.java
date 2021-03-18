package com.cg.apps.items.service;

import com.cg.apps.customer.dao.ICustomerRepository;
import com.cg.apps.customer.entities.Customer;
import com.cg.apps.items.dao.IItemRepository;
import com.cg.apps.items.entities.Item;
import com.cg.apps.items.exceptions.InvalidIdException;
import com.cg.apps.items.exceptions.InvalidPriceException;
import com.cg.apps.items.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

@Service
public class ItemServiceImp implements IItemService
{
    @Autowired
    private IItemRepository itemRepository;
    @Autowired
    private ICustomerRepository customerRepository;

    public String generateId()
    {
        Random random = new Random();
        String alphabet = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        char generate;
        for(int i=0;i<10;i++)
        {
            generate = alphabet.charAt(random.nextInt(alphabet.length()));
            sb.append(generate);
        }
        String id = sb.toString();
        return id;
    }

    @Transactional
    @Override
    public Item create(Double price, String description)
    {
        validatePrice(price);
        String id = generateId();
        Item item = new Item();
        LocalDateTime localDateTime = LocalDateTime.now();

        item.setId(id);
        item.setPrice(price);
        item.setDescription(description);
        item.setAddedDate(localDateTime);

        item = itemRepository.save(item);
        return item;
    }

    @Override
    public Item findByID(String itemID)
    {
        validateItemId(itemID);
        Optional<Item> optional = itemRepository.findById(itemID);
        if(!optional.isPresent())
        {
            throw new ItemNotFoundException("Item does not exist");
        }
        Item item = optional.get();
        return item;
    }

    @Transactional
    @Override
    public Item buyItem(String itemID, Long customerID)
    {
        validateItemId(itemID);
        validateId(customerID);

        Optional<Customer> customerOptional = customerRepository.findById(customerID);
        Customer customer = customerOptional.get();
        Item item = findByID(itemID);

        item.setBoughtBy(customer);
        item = itemRepository.save(item);

        Set<Item> itemSet = customer.getBoughtItems();
        if(itemSet==null)
        {
            itemSet = new HashSet<>();
        }
        itemSet.add(item);
        customer.setBoughtItems(itemSet);

        Double balance = customer.getAccount().getBalance();
        balance = balance - item.getPrice();
        customer.getAccount().setBalance(balance);

        customerRepository.save(customer);
        return item;
    }

    public void validateId(Long id)
    {
        if(id<0)
        {
            throw new InvalidIdException("ID can't be negative");
        }
    }

    public void validateItemId(String id)
    {
        if(id==null || id.isEmpty() || id.trim().isEmpty())
        {
            throw new InvalidIdException("ID can't be null");
        }
    }

    public void validatePrice(Double price)
    {
        if(price==0)
        {
            throw new InvalidPriceException("Price can't be zero");
        }
    }

}
