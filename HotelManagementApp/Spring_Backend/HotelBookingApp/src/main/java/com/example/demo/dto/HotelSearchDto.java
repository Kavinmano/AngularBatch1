package com.example.demo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HotelSearchDto {
    private String location;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfRooms;
    private int numberOfAdults;
    private int numberOfChildren;
}
