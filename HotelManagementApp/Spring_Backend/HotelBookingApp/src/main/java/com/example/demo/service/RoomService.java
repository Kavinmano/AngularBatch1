package com.example.demo.service;

import com.example.demo.model.Hotel;
import com.example.demo.model.Room;
import com.example.demo.repo.HotelRepository;
import com.example.demo.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    public Room addRoom(Long hotelId, Room room) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow();
        room.setHotel(hotel);
        return roomRepository.save(room);
    }

    public List<Room> getAvailableRooms(Long hotelId) {
        return roomRepository.findByHotelIdAndAvailableTrue(hotelId);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}
