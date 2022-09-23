package com.pilgrims.travelagency.services;

import com.pilgrims.travelagency.exceptions.ContinentNotFoundException;
import com.pilgrims.travelagency.exceptions.CountryNotFoundException;
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
     * To find a country by name
     * @param name Name
     * @return Country
     */
    Country findCountryByName(String name) throws CountryNotFoundException;

    /**
     * To find a country by id
     * @param id id
     * @return country
     */
    Country findCountryById(UUID id) throws  CountryNotFoundException;

    /**
     * To find all countries
     * @return List of countries
     */
    List<Country> findAllCountries() throws CountryNotFoundException;

    /**
     * To update an existing Country
     *
     * @param country Country
     */
    void updateCountry(Country country) throws  CountryNotFoundException;

    /**
     * To delete a country by its ID
     * @param id id of country
     */
    void deleteCountryById(UUID id) throws  CountryNotFoundException;

    /**
     * To restore a not active country by its ID
     * @param id id of country
     */
    void restoreCountryById(UUID id) throws  CountryNotFoundException;


    List<Country> findAllCountriesByContinent(Continent continent) throws CountryNotFoundException;


}
