package com.cg.apps.items.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Item
{
    @Id
    private String id;
    private Double price;
    private String description;
    private LocalDateTime addedDate;

    public Item(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDateTime getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDateTime addedDate) {
        this.addedDate = addedDate;
    }

//    @Override
//    public String toString() {
//        return "Item{" +
//                "id='" + id + '\'' +
//                ", price=" + price +
//                ", description='" + description + '\'' +
//                ", addedDate=" + addedDate +
//                '}';
//    }
}
