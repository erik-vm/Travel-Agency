package com.pilgrims.travelagency.exceptions;

import java.util.UUID;

/**
 * Exception for country not found
 *
 * @author Erik Vainumäe
 */
public class CountryNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public CountryNotFoundException() {
        super("Countries not found!");
    }

    public CountryNotFoundException(String countryName) {
        super(String.format("Country not found with name=%s!", countryName));
    }

    public CountryNotFoundException(UUID uuid) {
        super(String.format("Country not found with id=%s!", uuid));
    }
}
