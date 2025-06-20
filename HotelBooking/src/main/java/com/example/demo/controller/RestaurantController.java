package com.example.demo.controller;

import com.example.demo.model.Restaurant;
import com.example.demo.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantRepository repo;

    @PostMapping("/add")
    public Restaurant add(@RequestBody Restaurant r) {
        return repo.save(r);
    }
    
    

    @GetMapping("/all")
    public List<Restaurant> all() {
        return repo.findAll();
    }

    @GetMapping("/byName/{name}")
    public List<Restaurant> byName(@PathVariable String name) {
        return repo.findByName(name);
    }

    @GetMapping("/byNameLocation")
    public ResponseEntity<Restaurant> byNameLocation(@RequestParam String name, @RequestParam String location) {
        return repo.findByNameAndLocation(name, location)
                   .map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Restaurant> byId(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @Autowired
    private RestaurantRepository restaurantRepository;
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Restaurant> update(@PathVariable Long id, @RequestBody Restaurant data) {
        return restaurantRepository.findById(id).map(r -> {
            r.setName(data.getName());
            r.setLocation(data.getLocation());
            return ResponseEntity.ok(restaurantRepository.save(r));
        }).orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
