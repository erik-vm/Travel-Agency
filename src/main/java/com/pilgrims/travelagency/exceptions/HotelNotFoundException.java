package com.pilgrims.travelagency.exceptions;

import java.util.UUID;

/**
 * Exception for hotel not found
 *
 * @author Erik Vainumäe
 */
public class HotelNotFoundException extends Exception{

    private static final long serialVersionUID = 1L;

    public HotelNotFoundException() {
        super("Hotels not found!");
    }

    public HotelNotFoundException(String hotelName) {
        super(String.format("Hotel not found with name=%s!", hotelName));
    }

    public HotelNotFoundException(UUID uuid) {
        super(String.format("Hotel not found with id=%s!", uuid));
    }
}
