package com.pilgrims.travelagency.services;

import com.pilgrims.travelagency.exceptions.AirportNotFoundException;
import com.pilgrims.travelagency.models.*;

import java.util.List;
import java.util.UUID;

public interface AirportService {

    /**
     * To create a new airport
     *
     * @param airport Airport
     */
    void createAirport(Airport airport);

    /**
     * To find an airport by city
     * @param city City
     * @return List of airports
     */
    List<Airport> findAirportsByCity(City city) throws AirportNotFoundException;

    /**
     * To find an airport by country
     * @param country Country
     * @return List of airports
     */


    /**
     * To find an airport by name
     * @param name Name
     * @return Airport
     */
    Airport findAirportByName(String name) throws AirportNotFoundException;

    /**
     * To find an airport by id
     * @param id id
     * @return airport
     */
    Airport findAirportById(UUID id) throws AirportNotFoundException;

    /**
     * To find all airports
     * @return List of airports
     */
    List<Airport> findAllAirports() throws AirportNotFoundException;

    /**
     * To update an existing Airport
     *
     * @param airport Airport
     */
    void updateAirport(Airport airport) throws AirportNotFoundException;

    /**
     * To delete a airport by its ID
     * @param id id of airport
     */
    void deleteAirportById(UUID id) throws AirportNotFoundException;

    /**
     * To restore a not active airport by its ID
     * @param id id of airport
     */
    void restoreAirportById(UUID id) throws AirportNotFoundException;


}
