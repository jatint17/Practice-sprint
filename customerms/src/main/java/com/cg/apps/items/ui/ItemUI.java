package com.cg.apps.items.ui;

import com.cg.apps.items.entities.Item;
import com.cg.apps.items.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemUI
{
    @Autowired
    private IItemService service;

    public void start()
    {
        Item shoe = service.create(3999.9,"Sports Shoes");
        Item shirt = service.create(1299.9,"Formal Shirt");
        display(shoe);
        display(shirt);
    }
    public void display(Item item)
    {
        System.out.println(item.getId());
    }
}
