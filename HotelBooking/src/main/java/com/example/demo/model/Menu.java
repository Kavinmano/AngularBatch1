package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Menu {
    @Id
    @GeneratedValue
    private Long id;

    private String itemName;
    private Double price;
    private Long restaurantId;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Long getRestaurantId() { return restaurantId; }
    public void setRestaurantId(Long restaurantId) { this.restaurantId = restaurantId; }
}
