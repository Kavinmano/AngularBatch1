package com.example.demo.service;

import com.example.demo.model.Review;
import com.example.demo.repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> getHotelReviews(Long hotelId) {
        return reviewRepository.findByHotelId(hotelId);
    }
}
