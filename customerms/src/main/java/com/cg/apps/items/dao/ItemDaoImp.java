package com.cg.apps.items.dao;

import com.cg.apps.items.entities.Item;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Random;

@Repository
public class ItemDaoImp implements IItemDao
{
    @PersistenceContext
    private EntityManager entityManager;

    public String generateId(Item item)
    {
        String des = item.getDescription();
        Random random = new Random();
        String alphabet = "1234567890";
        char generate = alphabet.charAt(random.nextInt(alphabet.length()));
        String randomChar = String.valueOf(generate);
        String id = des.substring(0,2).concat(randomChar);
        return id;
    }

    @Override
    public Item add(Item item)
    {
        String id = generateId(item);
        item.setId(id);
        entityManager.persist(item);
        return item;
    }

    @Override
    public Item update(Item item)
    {
        item = entityManager.merge(item);
        return item;
    }

    @Override
    public Item findByID(String itemID)
    {
        Item item = entityManager.find(Item.class,itemID);
        return item;
    }
}
