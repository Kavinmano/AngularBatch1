package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomType; // single, double, king
    private int maxPersons;
    private double baseFare;
    private boolean ac;
    private boolean available;

    private int sizeInSqft;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
