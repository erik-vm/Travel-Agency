package com.pilgrims.travelagency.exceptions;
import com.pilgrims.travelagency.models.City;

import java.util.UUID;

/**
 * Exception for airport not found
 *
 * @author Kimmo Pormann
 */
public class AirportNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public AirportNotFoundException() {
        super("No airports found!");
    }

    public AirportNotFoundException(UUID uuid) {
        super(String.format("Airport not found with id= %s!", uuid));
    }

    public AirportNotFoundException(String name) {
        super(String.format("Airport not found with searched name %s!", name));
    }

}
