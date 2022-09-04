package com.pilgrims.travelagency.services.implementations;

import com.pilgrims.travelagency.models.Hotel;
import com.pilgrims.travelagency.repositories.HotelRepository;
import com.pilgrims.travelagency.services.HotelService;
import com.sun.xml.bind.api.impl.NameConverter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        Optional<Hotel> optionalHotel = hotelRepository.findByCity(city);
        return null;
    }

    @Override
    public List<Hotel> findHotelsByCountry(Country country) {
        return null;
    }

    @Override
    public List<Hotel> findHotelsByStandard(NameConverter.Standard standard) {
        return null;
    }

    @Override
    public Hotel findHotelByName(String name) {
        return null;
    }

    @Override
    public void editHotel(Hotel hotel) {

    }

    @Override
    public void deleteHotelById(UUID id) {

    }

    @Override
    public void restoreHotelById(UUID id) {

    }
}
