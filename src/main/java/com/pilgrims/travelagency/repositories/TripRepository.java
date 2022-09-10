package com.pilgrims.travelagency.repositories;

import com.pilgrims.travelagency.models.City;
import com.pilgrims.travelagency.models.Trip;
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

    List<Trip> findTripByContinent(City city);

    List<Trip> findTripByDuration(double duration);

    List<Trip> findTripByPrice(double price);
}
