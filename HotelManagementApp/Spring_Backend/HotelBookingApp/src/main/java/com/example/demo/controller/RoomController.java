package com.example.demo.controller;

import com.example.demo.model.Room;
import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/add/{hotelId}")
    public Room addRoom(@PathVariable Long hotelId, @RequestBody Room room) {
        return roomService.addRoom(hotelId, room);
    }

    @GetMapping("/available/{hotelId}")
    public List<Room> getAvailableRooms(@PathVariable Long hotelId) {
        return roomService.getAvailableRooms(hotelId);
    }

    @GetMapping("/all")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }
}