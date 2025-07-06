package com.example.demo.dto;

import lombok.Data;

@Data
public class ReviewDto {
    private Long hotelId;
    private Long userId;
    private int rating;         // e.g., 1 to 5
    private String comment;
}
