package com.pilgrims.travelagency.repositories;

import com.pilgrims.travelagency.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/** Repository to handle trip related DB operations
 *
 * @author Ott Pikk
 */

@Repository
public interface TripRepository extends JpaRepository<Trip, UUID> {


    List<Trip> findByDepartureCity(City departureCity);

    List<Trip> findByArrivalCity(City arrivalCity);

    List<Trip> findByDepartureCityAndArrivalCity(City departureCity, City arrivalCity);
    List<Trip> findByDepartureAirport(Airport departureAirport);

    List<Trip> findByArrivalAirport(Airport arrivalAirport);
    List<Trip> findByDepartureAirportAndArrivalAirport(Airport departureAirport, Airport arrivalAirport);
}
