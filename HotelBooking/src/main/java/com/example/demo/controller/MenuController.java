package com.example.demo.controller;

import com.example.demo.model.Menu;
import com.example.demo.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuRepository repo;

    @GetMapping("/byRestaurant/{restaurantId}")
    public List<Menu> byRestaurant(@PathVariable Long restaurantId) {
        return repo.findByRestaurantId(restaurantId);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Menu> byId(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
