package com.example.demo.repo;

import com.example.demo.model.Room;
import com.example.demo.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByHotelAndAvailableTrue(Hotel hotel);
    List<Room> findByHotelIdAndAvailableTrue(Long hotelId);

}
