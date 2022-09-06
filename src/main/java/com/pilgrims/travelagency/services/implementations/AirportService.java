package com.pilgrims.travelagency.services.implementations;

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
     * @param airport Airport
     * @return List of airports
     */
    List<Airport> findAirportsByCity(City city);

    /**
     * To find an airport by country
     * @param country Country
     * @return List of airports
     */
    List<Airport> findAirportsByCountry(Country country);

    /**
     * To find an airport by name
     * @param name Name
     * @return Airport
     */
    Airport findAirportByName(String name);

    /**
     * To find an airport by id
     * @param id id
     * @return airport
     */
    Airport findAirportById(UUID id);

    /**
     * To find all airports
     * @return List of airports
     */
    List<Airport> findAllAirports();

    /**
     * To update an existing Airport
     *
     * @param airport Airport
     */
    void updateAirport(Airport airport);

    /**
     * To delete a airport by its ID
     * @param id id of airport
     */
    void deleteAirportById(UUID id);

    /**
     * To restore a not active airport by its ID
     * @param id id of airport
     */
    void restoreAirportById(UUID id);


}