package com.example.demo.repo;

import com.example.demo.model.Review;
import com.example.demo.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByHotel(Hotel hotel);
    List<Review> findByHotelId(Long hotelId);

}
