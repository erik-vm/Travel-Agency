package com.pilgrims.travelagency.services;

import com.pilgrims.travelagency.exceptions.TripNotFoundException;
import com.pilgrims.travelagency.models.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *  To handle trip related operations
 *
 *  @author Ott Pikk
 */
public interface TripService {

    /**
     * Create a new trip
     *
     * @param trip trip
     */
    void createTrip(Trip trip);

    /**
     * To find all trips
     *
     * @return list of trips
     */
    List<Trip> findAllTrips() throws TripNotFoundException;

    /**
     * To find a trip by id
     * @param id id
     * @return trip
     */
    Trip findTripById(UUID id) throws TripNotFoundException;

    /**
     * To update existing trip
     *
     * @param trip trip
     */
    void updateTrip(Trip trip) throws TripNotFoundException;

    /**
     * To delete existing trip
     *
     * @param id id
     */
    void deleteTrip(UUID id) throws TripNotFoundException;

    /**
     * To restore a not active trip by its id
     *
     * @param id id of trip
     */
    void restoreTrip(UUID id) throws TripNotFoundException;

//    /**
//     * To find trip by country
//     *
//     * @param country country
//     * @return list of trips
//     */
//    List<Trip> findTripsByCountry(Country country);
//
//    /**
//     * To find trip by continent
//     *
//     * @param continent continent
//     * @return list of trips
//     */
//    List<Trip> findTripByContinent(Continent continent);
//
//
//    /** To find trip by duration
//     *
//     * @param duration duration
//     * @return list of trips
//     */
//    List<Trip> findTripsByDuration(double duration);
//
//    /** To find trip by price
//     *
//     * @param price price
//     * @return list of trips
//     */
//    List<Trip> findTripsByPrice(double price);
//
//    /**
//     * To find trips from departure city
//     *
//     * @param departureCity City
//     * @return list of trips
//     */
    List<Trip> findByDepartureCity(City departureCity) throws TripNotFoundException;

    /**
     * To find trips to arrival city
     *
     * @param arrivalCity City
     * @return list of trips
     */
    List<Trip> findByArrivalCity(City arrivalCity) throws TripNotFoundException;

    /**
     * To find trips from departure airport
     *
     * @param departureAirport Airport
     * @return list of trips
     */
    List<Trip> findByDepartureAirport(Airport departureAirport) throws TripNotFoundException;

    /**
     * To find trips to arrival airport
     *
     * @param arrivalAirport Airport
     * @return list of trips
     */
    List<Trip> findByArrivalAirport(Airport arrivalAirport) throws TripNotFoundException;

    /**
     * To find trips from departure airport to arrival airport
     *
     * @param departureAirport Airport
     * @param arrivalAirport Airport
     * @return list of trips
     */
    List<Trip> findByDepartureAirportAndArrivalAirport(Airport departureAirport, Airport arrivalAirport) throws TripNotFoundException;

    /**
     * To find trips from departure city to arrival city
     *
     * @param departureCity City
     * @param arrivalCity City
     * @return list of trips
     */
    List<Trip> findByDepartureCityAndArrivalCity(City departureCity, City arrivalCity) throws TripNotFoundException;
}
