package com.pilgrims.travelagency.exceptions;

/**
 * Exception for continent not found
 *
 * @author Erik Vainumäe
 */
public class ContinentNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public ContinentNotFoundException(String continentName) {
        super(String.format("Continent not found with name=%s!", continentName));
    }
}
