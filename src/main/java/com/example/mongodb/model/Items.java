package com.example.mongodb.model;

import java.util.List;
import java.util.Objects;

public class Items {

    private String name;
    private Double price;
    private Integer quantity;
    private List<String> tags;

    public Items(String name, Double price, Integer quantity, List<String> tags) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.tags = tags;
    }

    public Items() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items items = (Items) o;
        return Objects.equals(getName(), items.getName()) && Objects.equals(getPrice(), items.getPrice()) && Objects.equals(getQuantity(), items.getQuantity()) && Objects.equals(getTags(), items.getTags());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getQuantity(), getTags());
    }

    @Override
    public String toString() {
        return "Items{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", tags=" + tags +
                '}';
    }
}
