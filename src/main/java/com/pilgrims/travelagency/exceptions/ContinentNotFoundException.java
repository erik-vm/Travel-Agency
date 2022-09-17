package com.pilgrims.travelagency.exceptions;

public class ContinentNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public ContinentNotFoundException(String continentName) {
        super(String.format("Continent not found with name=%s!", continentName));
    }
}
