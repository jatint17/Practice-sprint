package com.cg.apps.items.service;

import com.cg.apps.customer.dao.ICustomerDao;
import com.cg.apps.customer.entities.Customer;
import com.cg.apps.items.dao.IItemDao;
import com.cg.apps.items.entities.Item;
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
        Item item = dao.findByID(itemID);
        return item;
    }

    @Transactional
    @Override
    public Item buyItem(String itemID, Long customerID)
    {
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
}
