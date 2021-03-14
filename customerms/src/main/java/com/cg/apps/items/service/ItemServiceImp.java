package com.cg.apps.items.service;

import com.cg.apps.customer.dao.ICustomerDao;
import com.cg.apps.customer.entities.Customer;
import com.cg.apps.items.dao.IItemDao;
import com.cg.apps.items.entities.Item;
import com.cg.apps.items.exceptions.InvalidIdException;
import com.cg.apps.items.exceptions.InvalidPriceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class ItemServiceImp implements IItemService
{
    @Autowired
    private IItemDao dao;
    @Autowired
    private ICustomerDao customerDao;


    @Transactional
    @Override
    public Item create(Double price, String description)
    {
        validatePrice(price);

        Item item = new Item();
        LocalDateTime localDateTime = LocalDateTime.now();

        item.setPrice(price);
        item.setDescription(description);
        item.setAddedDate(localDateTime);

        item = dao.add(item);
        return item;
    }

    @Override
    public Item findByID(String itemID)
    {
        validateItemId(itemID);

        Item item = dao.findByID(itemID);
        return item;
    }

    @Transactional
    @Override
    public Item buyItem(String itemID, Long customerID)
    {
        validateItemId(itemID);
        validateId(customerID);

        Item item = findByID(itemID);
        Customer customer = customerDao.findByID(customerID);
        item.setBoughtBy(customer);
        item = dao.update(item);

        Set<Item> itemSet = customer.getBoughtItems();
        if(itemSet==null)
        {
            itemSet = new HashSet<>();
        }
        customer.setBoughtItems(itemSet);

        itemSet.add(item);
        customerDao.update(customer);
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
