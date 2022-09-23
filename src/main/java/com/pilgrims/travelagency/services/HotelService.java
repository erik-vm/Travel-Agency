package com.pilgrims.travelagency.services;

import com.pilgrims.travelagency.exceptions.HotelNotFoundException;
import com.pilgrims.travelagency.models.City;
import com.pilgrims.travelagency.models.Country;
import com.pilgrims.travelagency.models.Hotel;
import com.pilgrims.travelagency.models.HotelStandard;

import java.util.List;
import java.util.UUID;

/**
 * To handle hotel related operations
 *
 * @author Ott Pikk
 */
public interface HotelService {

    /**
     * To create a new hotel
     *
     * @param hotel Hotel
     */
    void createHotel(Hotel hotel);

    /**
     * To find a hotel by city
     * @param city City
     * @return List of hotels
     */
    List<Hotel> findHotelsByCity(City city) throws HotelNotFoundException;


    /**
     * To find a hotel by standard
     * @param hotelStandard Standard
     * @return List of hotels
     */
    List<Hotel> findHotelsByStandard(HotelStandard hotelStandard) throws HotelNotFoundException;

    /**
     * To find a hotel by name
     * @param name Name
     * @return Hotel
     */
    Hotel findHotelByName(String name) throws HotelNotFoundException;

    /**
     * To find a hotel by id
     * @param id id
     * @return hotel
     */
    Hotel findHotelById(UUID id) throws HotelNotFoundException;

    /**
     * To find all hotels
     * @return List of hotels
     */
    List<Hotel> findAllHotels() throws HotelNotFoundException;

    /**
     * To update a existing Hotel
     *
     * @param hotel Hotel
     */
    void updateHotel(Hotel hotel) throws HotelNotFoundException;

    /**
     * To delete a hotel by its ID
     * @param id id of hotel
     */
    void deleteHotelById(UUID id) throws HotelNotFoundException;

    /**
     * To restore a not active hotel by its ID
     * @param id id of hotel
     */
    void restoreHotelById(UUID id) throws HotelNotFoundException;


}
