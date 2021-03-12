package com.cg.apps.items.dao;

import com.cg.apps.items.entities.Item;

public interface IItemDao
{
    Item add(Item item);
    Item update(Item item);
    Item findByID(String itemID);
}
