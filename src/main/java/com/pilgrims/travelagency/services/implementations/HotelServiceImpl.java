package com.pilgrims.travelagency.services.implementations;

import com.pilgrims.travelagency.models.Hotel;
import com.pilgrims.travelagency.repositories.HotelRepository;
import com.pilgrims.travelagency.services.HotelService;
import com.sun.xml.bind.api.impl.NameConverter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Implementation of HotelService
 *
 * @author Ott Pikk
 */

@Service
@Transactional
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;

    @Override
    public void createHotel(Hotel hotel) {
        hotel.setActive(true);
        hotelRepository.save(hotel);

    }

    @Override
    public List<Hotel> findHotelsByCity(City city) {
        return hotelRepository.findByCity(city);
    }

    @Override
    public List<Hotel> findHotelsByCountry(Country country) {
        return hotelRepository.findByCountry(country);
    }

    @Override
    public List<Hotel> findHotelsByStandard(String standard) {
        return hotelRepository.findByStandard(standard);
    }

    @Override
    public Hotel findHotelByName(String name) {
        Optional<Hotel> optionalHotel = hotelRepository.findByName(name);
        return optionalHotel.get();
    }

    @Override
    public void editHotel(Hotel hotel) {
        if (findHotelById(hotel.getId()) != null) {
            hotelRepository.saveAndFlush(hotel);
        }
    }

    public Hotel findHotelById (UUID id) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        return optionalHotel.get();
    }

    @Override
    public List<Hotel> findAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public void deleteHotelById(UUID id) {
        Hotel hotel = findHotelById(id);
        hotel.setActive(false);
        hotelRepository.saveAndFlush(hotel);
    }

    @Override
    public void restoreHotelById(UUID id) {
        Hotel hotel = findHotelById(id);
        hotel.setActive(true);
        hotelRepository.saveAndFlush(hotel);

    }
}
