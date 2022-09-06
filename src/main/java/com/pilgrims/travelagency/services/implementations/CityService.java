package com.pilgrims.travelagency.services.implementations;

import com.pilgrims.travelagency.models.City;
import com.pilgrims.travelagency.models.Hotel;
import com.pilgrims.travelagency.models.HotelStandard;

import java.util.List;
import java.util.UUID;

public interface CityService {

    /**
     * To create a new city
     *
     * @param city City
     */
    default void createCity(City city) {

    }


    /**
     * To find a city by name
     * @param name Name
     * @return City
     */
    City findCityByName(String name);

    /**
     * To find a city by id
     * @param id id
     * @return city
     */
    City findCityById(UUID id);

    /**
     * To find all cities
     * @return List of cities
     */
    List<City> findAllCities();

    /**
     * To update an existing City
     *
     * @param city City
     */
    void updateCity(City city);

    /**
     * To delete a cities by its ID
     * @param id id of city
     */
    void deleteCityById(UUID id);

    /**
     * To restore a not active hotel by its ID
     * @param id id of city
     */
    void restoreCityById(UUID id);


}
