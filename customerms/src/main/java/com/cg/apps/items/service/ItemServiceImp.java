package com.cg.apps.items.service;

import com.cg.apps.items.dao.IItemDao;
import com.cg.apps.items.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class ItemServiceImp implements IItemService
{
    @Autowired
    private IItemDao dao;



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

//    @Override
//    public Item buyItem(String itemID, Long customerID)
//    {
//        return null;
//    }
}
