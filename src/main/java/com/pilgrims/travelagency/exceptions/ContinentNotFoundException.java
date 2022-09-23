package com.pilgrims.travelagency.exceptions;

import java.util.UUID;

/**
 * Exception for continent not found
 *
 * @author Erik Vainumäe
 */
public class ContinentNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public ContinentNotFoundException() {
        super("Continents not found!");
    }

    public ContinentNotFoundException(String continentName) {
        super(String.format("Continent not found with name=%s!", continentName));
    }

    public ContinentNotFoundException(UUID uuid) {
        super(String.format("Continent not found with id=%s!", uuid));
    }
}
