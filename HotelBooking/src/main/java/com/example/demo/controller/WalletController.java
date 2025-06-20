package com.example.demo.controller;

import com.example.demo.model.Wallet;
import com.example.demo.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    @Autowired
    private WalletRepository repo;

    @PostMapping("/add")
    public Wallet add(@RequestBody Wallet w) {
        return repo.save(w);
    }

    @GetMapping("/all")
    public List<Wallet> all() {
        return repo.findAll();
    }

    @GetMapping("/byCustomer/{customerId}")
    public List<Wallet> byCustomer(@PathVariable Long customerId) {
        return repo.findByCustomerId(customerId);
    }
}
