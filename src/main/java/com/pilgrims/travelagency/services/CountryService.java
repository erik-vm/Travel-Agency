package com.pilgrims.travelagency.services;

import com.pilgrims.travelagency.models.*;

import java.util.List;
import java.util.UUID;

public interface CountryService {

    /**
     * To create a new country
     *
     * @param country Country
     */
    void createCountry(Country country);

    /**
     * To find a country by city
     * @param city City
     * @return List of countries
     */

    List<Country> findCountriesByCity(City city);

    /**
     * To find a country by name
     * @param name Name
     * @return Country
     */
    Country findCountriesByName(String name);

    /**
     * To find a country by id
     * @param id id
     * @return country
     */
    Country findCountryById(UUID id);

    /**
     * To find all countries
     * @return List of countries
     */
    List<Country> findAllCountries();

    /**
     * To update an existing Country
     *
     * @param country Country
     */
    void updateCountry(Country country);

    /**
     * To delete a country by its ID
     * @param id id of country
     */
    void deleteCountryById(UUID id);

    /**
     * To restore a not active country by its ID
     * @param id id of country
     */
    void restoreCountryById(UUID id);


}