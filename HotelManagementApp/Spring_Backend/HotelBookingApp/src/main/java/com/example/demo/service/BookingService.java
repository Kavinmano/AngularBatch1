package com.example.demo.service;

import com.example.demo.model.Booking;
import com.example.demo.model.Room;
import com.example.demo.repo.BookingRepository;
import com.example.demo.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomRepository roomRepository;

    public Booking bookRoom(Long roomId, Booking booking) {
        Room room = roomRepository.findById(roomId).orElseThrow();
        booking.setRoom(room);
        booking.setTotalFare(room.getBaseFare()); // Placeholder for dynamic fare
        return bookingRepository.save(booking);
    }

    public List<Booking> getUserBookings(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public void cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow();
        booking.setCancelled(true);
        bookingRepository.save(booking);
    }
}
