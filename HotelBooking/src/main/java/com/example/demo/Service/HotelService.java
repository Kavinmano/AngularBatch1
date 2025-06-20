package com.example.demo.Service;

import com.example.demo.model.Hotel;
import java.util.List;

public interface HotelService {
    Hotel addHotel(Hotel hotel);
    List<Hotel> getAllHotels();
    Hotel getHotelById(Long id);
    Hotel updateHotel(Long id, Hotel hotel);
    void deleteHotel(Long id);
}
