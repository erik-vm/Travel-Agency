package com.pilgrims.travelagency.services.implementations;

import com.pilgrims.travelagency.exceptions.HotelNotFoundException;
import com.pilgrims.travelagency.models.City;
import com.pilgrims.travelagency.models.Country;
import com.pilgrims.travelagency.models.Hotel;
import com.pilgrims.travelagency.models.HotelStandard;
import com.pilgrims.travelagency.repositories.HotelRepository;
import com.pilgrims.travelagency.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public void createHotel(Hotel hotel) {
        hotel.setActive(true);
        hotelRepository.save(hotel);

    }

    @Override
    public List<Hotel> findHotelsByCity(City city) throws HotelNotFoundException {
        if (hotelRepository.findByCity(city).isEmpty()){
            throw new HotelNotFoundException();
        }
        return hotelRepository.findByCity(city);
    }


    @Override
    public List<Hotel> findHotelsByStandard(HotelStandard hotelStandard) throws HotelNotFoundException {
        if (hotelRepository.findByHotelStandard(hotelStandard).isEmpty()){
            throw new HotelNotFoundException();
        }
        return hotelRepository.findByHotelStandard(hotelStandard);
    }

    @Override
    public Hotel findHotelByName(String name) throws HotelNotFoundException {
        Optional<Hotel> optionalHotel = hotelRepository.findByName(name);
        if (optionalHotel.isEmpty()){
            throw new HotelNotFoundException(name);
        }
        return optionalHotel.get();
    }

    @Override
    public void updateHotel(Hotel hotel) throws HotelNotFoundException {
        if (findHotelById(hotel.getId()) != null) {
            hotelRepository.saveAndFlush(hotel);
        }
    }

    public Hotel findHotelById (UUID id) throws HotelNotFoundException {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        if (optionalHotel.isEmpty()){
            throw new HotelNotFoundException(id);
        }
        return optionalHotel.get();
    }

    @Override
    public List<Hotel> findAllHotels() throws HotelNotFoundException {
        if (hotelRepository.findAll().isEmpty()){
            throw new HotelNotFoundException();
        }
        return hotelRepository.findAll();
    }

    @Override
    public void deleteHotelById(UUID id) throws HotelNotFoundException {
        Hotel hotel = findHotelById(id);
        hotel.setActive(false);
        hotelRepository.saveAndFlush(hotel);
    }

    @Override
    public void restoreHotelById(UUID id) throws HotelNotFoundException {
        Hotel hotel = findHotelById(id);
        hotel.setActive(true);
        hotelRepository.saveAndFlush(hotel);

    }
}
