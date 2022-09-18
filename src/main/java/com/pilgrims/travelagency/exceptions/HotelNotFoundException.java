package com.pilgrims.travelagency.exceptions;

/**
 * Exception for hotel not found
 *
 * @author Erik Vainumäe
 */
public class HotelNotFoundException extends Exception{

    private static final long serialVersionUID = 1L;

    public HotelNotFoundException(String hotelName) {
        super(String.format("Hotel not found with name=%s!", hotelName));
    }
}
