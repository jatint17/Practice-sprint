package com.cg.apps.items.service;

import com.cg.apps.items.entities.Item;

public interface IItemService
{
    Item create(Double price, String description);
    Item findByID(String itemID);
    Item buyItem(String itemID, Long customerID);
}
