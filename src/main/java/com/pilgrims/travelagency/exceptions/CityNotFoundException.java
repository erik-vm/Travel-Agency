package com.pilgrims.travelagency.exceptions;

import com.pilgrims.travelagency.models.Airport;
import com.pilgrims.travelagency.models.City;

import java.util.UUID;

/**
 * Exception for city not found
 *
 * @author Kimmo Pormann
 */
public class CityNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public CityNotFoundException() {
        super("Cities not found!");
    }

    public CityNotFoundException(UUID uuid) {
        super(String.format("City not found with id= %s!", uuid));
    }

    public CityNotFoundException(String name) {
        super(String.format("City not found with name= %s!", name));
    }


}
