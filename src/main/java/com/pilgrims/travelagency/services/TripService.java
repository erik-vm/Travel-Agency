package com.pilgrims.travelagency.services;

import com.pilgrims.travelagency.models.City;
import com.pilgrims.travelagency.models.Hotel;
import com.pilgrims.travelagency.models.Trip;

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
    List<Trip> findAllTrips();

    /**
     * To find a trip by id
     * @param id id
     * @return trip
     */
    Trip findTripById(UUID id);

    /**
     * To update existing trip
     *
     * @param trip trip
     */
    void updateTrip(Trip trip);

    /**
     * To delete existing trip
     *
     * @param id id
     */
    void deleteTrip(UUID id);

    /**
     * To restore a not active trip by its id
     *
     * @param id id of trip
     */
    void restoreTrip(UUID id);



    /**
     * To find trip by continent
     *
     * @param city city
     * @return list of trips
     */
    //List<Trip> findTripsByContinent(City city);

    /**
     * To find trip by country
     *
     * @param city city
     * @return list of trips
     */
    //List<Trip> findTripsByCountry(City city);


    /** To find trip by duration
     *
     * @param duration duration
     * @return list of trips
     */
    List<Trip> findTripsByDuration(double duration);

    /** To find trip by price
     *
     * @param price price
     * @return list of trips
     */
    List<Trip> findTripsByPrice(double price);
}
