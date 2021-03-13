package com.cg.apps.items.dao;

import com.cg.apps.items.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.Random;

@Repository
public class ItemDaoImp implements IItemDao
{
    @Autowired
    private EntityManager entityManager;

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

    @Override
    public Item add(Item item)
    {
        String id = generateId();
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
