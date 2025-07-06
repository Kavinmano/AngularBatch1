package com.example.demo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingResponse {
    private Long bookingId;
    private Long userId;
    private Long roomId;
    private String hotelName;
    private String roomType;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfAdults;
    private int numberOfChildren;
    private double totalFare;
    private String status; // e.g., "CONFIRMED", "CANCELLED"
}
