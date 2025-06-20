package com.example.demo.repository;

import com.example.demo.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByName(String name);
    Optional<Restaurant> findByNameAndLocation(String name, String location);
}
