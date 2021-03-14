package com.cg.apps.items.controller;

import com.cg.apps.customer.service.ICustomerService;
import com.cg.apps.items.dto.ItemDetails;
import com.cg.apps.items.entities.Item;
import com.cg.apps.items.service.IItemService;
import com.cg.apps.items.util.ItemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RequestMapping("/items")
@RestController
public class ItemRestController
{
    @Autowired
    private IItemService service;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ItemUtil util;

    @GetMapping(value = "/itemsboughtbyid/{id}")
    private Set<ItemDetails> itemsBought(@PathVariable("id") Long customerId)
    {
        Set<Item> itemSet = customerService.itemsBoughtByCustomer(customerId);
        Set<ItemDetails> itemDetailsSet = util.toDetails(itemSet);
        return itemDetailsSet;
    }
}
