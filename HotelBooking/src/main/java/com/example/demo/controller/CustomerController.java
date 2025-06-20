package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository repo;

    @PostMapping("/add")
    public Customer add(@RequestBody Customer c) {
        return repo.save(c);
    }

    @GetMapping("/all")
    public List<Customer> all() {
        return repo.findAll();
    }

    @GetMapping("/byUsername/{username}")
    public ResponseEntity<Customer> byUsername(@PathVariable String username) {
        return repo.findByUsername(username).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/login")
    public ResponseEntity<Customer> login(@RequestBody Customer c) {
        return repo.findByUsernameAndPassword(c.getUsername(), c.getPassword())
                   .map(ResponseEntity::ok)
                   .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}
