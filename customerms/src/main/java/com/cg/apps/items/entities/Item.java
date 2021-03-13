package com.cg.apps.items.entities;

import com.cg.apps.customer.entities.Customer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Item
{
    @Id
    private String id;
    private Double price;
    private String description;

    @ManyToOne
    private Customer boughtBy;
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

    public Customer getBoughtBy() {
        return boughtBy;
    }

    public void setBoughtBy(Customer boughtBy) {
        this.boughtBy = boughtBy;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", boughtBy=" + boughtBy +
                ", addedDate=" + addedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) && Objects.equals(price, item.price) && Objects.equals(description, item.description) && Objects.equals(boughtBy, item.boughtBy) && Objects.equals(addedDate, item.addedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, description, boughtBy, addedDate);
    }
}
