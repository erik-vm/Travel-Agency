package com.pilgrims.travelagency.services.implementations;

import com.pilgrims.travelagency.models.City;
import com.pilgrims.travelagency.models.Continent;
import com.pilgrims.travelagency.models.Hotel;
import com.pilgrims.travelagency.models.Trip;
import com.pilgrims.travelagency.repositories.TripRepository;
import com.pilgrims.travelagency.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Implementation of TripService
 *
 * @author Ott PIkk
 */

@Service
@Transactional
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;


    @Override
    public void createTrip(Trip trip) {
        trip.setActive(true);
        tripRepository.save(trip);

    }

    @Override
    public List<Trip> findAllTrips() {
        return tripRepository.findAll();
    }

    @Override
    public Trip findTripById(UUID id) {
        Optional<Trip> optionalTrip = tripRepository.findById(id);
        return optionalTrip.get();
    }

    @Override
    public void updateTrip(Trip trip) {
        if (findTripById(trip.getId()) != null) {
            tripRepository.saveAndFlush(trip);
        }

    }

    @Override
    public void deleteTrip(UUID id) {
        Trip trip = findTripById(id);
        trip.setActive(false);
        tripRepository.saveAndFlush(trip);
    }

    @Override
    public void restoreTrip(UUID id) {
        Trip trip = findTripById(id);
        trip.setActive(true);
        tripRepository.saveAndFlush(trip);
    }

    @Override
    public List<Trip> findTripsByContinent(City city) {
        return tripRepository.findTripByContinent(city);
    }

    @Override
    public List<Trip> findTripsByCountry(City city) {
        return tripRepository.findTripByContinent(city);
    }

    @Override
    public List<Trip> findTripsByDuration(double duration) {
        return tripRepository.findTripByDuration(duration);
    }

    @Override
    public List<Trip> findTripsByPrice(double price) {
        return tripRepository.findTripByPrice(price);
    }
}
