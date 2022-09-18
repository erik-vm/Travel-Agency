package com.pilgrims.travelagency.exceptions;

import com.pilgrims.travelagency.models.Airport;
import com.pilgrims.travelagency.models.City;

import java.util.UUID;

/**
 * Exception for trip not found
 *
 * @author Erik Vainumäe
 */
public class TripNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public TripNotFoundException() {
        super("No trips found!");
    }

    public TripNotFoundException(UUID uuid) {
        super(String.format("Trip not found with id= %s!", uuid));
    }

    public TripNotFoundException(City city) {
        super(String.format("Trip not found with searched city %s!", city.getName()));
    }

    public TripNotFoundException(City departureCity, City arrivalCity) {
        super(String.format("Trip not found with from %s to %s!", departureCity.getName(), arrivalCity.getName()));
    }

    public TripNotFoundException(Airport airport) {
        super(String.format("Trip not found with searched airport %s!", airport.getName()));
    }

    public TripNotFoundException(Airport departureAirport, Airport arrivalAirport) {
        super(String.format("Trip not found with from %s to %s!", departureAirport.getName(), arrivalAirport.getName()));
    }
}
