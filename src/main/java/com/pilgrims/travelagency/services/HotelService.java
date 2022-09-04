package com.pilgrims.travelagency.services;

import com.pilgrims.travelagency.models.Hotel;
import com.sun.xml.bind.api.impl.NameConverter;

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
    List<Hotel> findHotelsByCity(City city);

    /**
     * To find a hotel by country
     * @param country Country
     * @return List of hotels
     */
    List<Hotel> findHotelsByCountry(Country country);

    /**
     * To find a hotel by standard
     * @param standard Standard
     * @return List of hotels
     */
    List<Hotel> findHotelsByStandard(NameConverter.Standard standard);

    /**
     * To find a hotel by name
     * @param name Name
     * @return Hotel
     */
    Hotel findHotelByName(String name);

    /**
     * To update a existing Hotel
     *
     * @param hotel Hotel
     */
    void editHotel(Hotel hotel);

    /**
     * To delete a hotel by its ID
     * @param id id of hotel
     */
    void deleteHotelById(UUID id);

    /**
     * To restore a not active hotel by its ID
     * @param id id of hotel
     */
    void restoreHotelById(UUID id);
}
