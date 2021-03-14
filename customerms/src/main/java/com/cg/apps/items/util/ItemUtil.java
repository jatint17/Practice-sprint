package com.cg.apps.items.util;

import com.cg.apps.items.dto.ItemDetails;
import com.cg.apps.items.entities.Item;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;

@Component
public class ItemUtil
{
    public ItemDetails toDetail(Item item)
    {
        ItemDetails itemDetails = new ItemDetails(item.getId(), item.getPrice(), item.getDescription());
        return itemDetails;
    }
    public Set<ItemDetails> toDetails(Set<Item> itemSet)
    {
        Set<ItemDetails>itemDetailsSet = new HashSet<>();
        for(Item item:itemSet)
        {
            ItemDetails itemDetails = toDetail(item);
            itemDetailsSet.add(itemDetails);
        }
        return itemDetailsSet;
    }
}
