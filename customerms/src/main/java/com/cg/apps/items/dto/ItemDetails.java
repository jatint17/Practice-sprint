package com.cg.apps.items.dto;

public class ItemDetails
{
    private Long itemId;
    private Double price;
    private String description;

    public ItemDetails(String id, Double price, String description){}
    public ItemDetails(Long itemId, Double price, String description)
    {
        this.itemId=itemId;
        this.price=price;
        this.description=description;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
