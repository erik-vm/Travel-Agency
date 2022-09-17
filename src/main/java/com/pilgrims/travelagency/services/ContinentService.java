package com.pilgrims.travelagency.services;

import com.pilgrims.travelagency.exceptions.ContinentNotFoundException;
import com.pilgrims.travelagency.models.City;
import com.pilgrims.travelagency.models.Continent;
import com.pilgrims.travelagency.models.Country;

import java.util.List;
import java.util.UUID;

public interface ContinentService {

    /**
     * To create a new continent
     *
     * @param continent Continent
     */
    default void createContinent(Continent continent) {

    }


    /**
     * To find a continent by name
     * @param name Name
     * @return Continent
     */
    Continent findContinentByName(String name) throws ContinentNotFoundException;

    /**
     * To find a continent by id
     * @param id id
     * @return continent
     */
    Continent findContinentById(UUID id);

    /**
     * To find all continents
     * @return List of continents
     */
    List<Continent> findAllContinents();




}
