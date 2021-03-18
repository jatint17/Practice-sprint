package com.cg.apps.items.controller;

import com.cg.apps.items.dto.BuyItemRequest;
import com.cg.apps.customer.dto.CustomerDetails;
import com.cg.apps.customer.entities.Customer;
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

    @GetMapping(value = "/byid/{id}")
    public ItemDetails getDetails(@PathVariable("id")String itemId)
    {
        Item item = service.findByID(itemId);
        ItemDetails itemDetails = util.toDetail(item);
        return itemDetails;
    }

    @PutMapping(value = "/buyitem")
    public ItemDetails buyItem(@RequestBody BuyItemRequest buyItemRequest)
    {
        Item item = service.buyItem(buyItemRequest.getItemId(), buyItemRequest.getCustomerId());
        ItemDetails itemDetails = util.toDetail(item);
        return itemDetails;
    }

    @GetMapping(value = "/boughtbyid/{id}")
    public Set<ItemDetails> itemsBoughtBy(@PathVariable("id")Long customerId)
    {
        Set<Item>itemSet = customerService.itemsBoughtByCustomer(customerId);
        Set<ItemDetails> itemDetails = util.toDetails(itemSet);
        return itemDetails;
    }

}
