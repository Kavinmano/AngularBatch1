package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Wallet {
    @Id
    @GeneratedValue
    private Long id;

    private Double balance;
    private Long customerId;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getBalance() { return balance; }
    public void setBalance(Double balance) { this.balance = balance; }

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
}
