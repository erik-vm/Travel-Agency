package com.pilgrims.travelagency.services.implementations;

import com.pilgrims.travelagency.exceptions.TripNotFoundException;
import com.pilgrims.travelagency.models.*;
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
    public List<Trip> findAllTrips() throws TripNotFoundException {
        if (tripRepository.findAll().isEmpty()){
            throw new TripNotFoundException();
        }
        return tripRepository.findAll();
    }

    @Override
    public Trip findTripById(UUID id) throws TripNotFoundException {
        Optional<Trip> optionalTrip = tripRepository.findById(id);
        if (optionalTrip.isEmpty()){
            throw new TripNotFoundException(id);
        }
        return optionalTrip.get();
    }

    @Override
    public void updateTrip(Trip trip) throws TripNotFoundException {
        if (findTripById(trip.getId()) != null) {
            tripRepository.saveAndFlush(trip);
        }

    }

    @Override
    public void deleteTrip(UUID id) throws TripNotFoundException {
        Trip trip = findTripById(id);
        trip.setActive(false);
        tripRepository.saveAndFlush(trip);
    }

    @Override
    public void restoreTrip(UUID id) throws TripNotFoundException {
        Trip trip = findTripById(id);
        trip.setActive(true);
        tripRepository.saveAndFlush(trip);
    }


    @Override
    public List<Trip> findByDepartureCity(City departureCity) throws TripNotFoundException {
        if (tripRepository.findByDepartureCity(departureCity).isEmpty()){
            throw new TripNotFoundException(departureCity);
        }
        return tripRepository.findByDepartureCity(departureCity);
    }

    @Override
    public List<Trip> findByArrivalCity(City arrivalCity) throws TripNotFoundException {
        if (tripRepository.findByArrivalCity(arrivalCity).isEmpty()){
            throw new TripNotFoundException(arrivalCity);
        }
        return tripRepository.findByArrivalCity(arrivalCity);
    }

    @Override
    public List<Trip> findByDepartureAirport(Airport departureAirport) throws TripNotFoundException {
        if (tripRepository.findByDepartureAirport(departureAirport).isEmpty()){
            throw new TripNotFoundException(departureAirport);
        }
        return tripRepository.findByDepartureAirport(departureAirport);
    }

    @Override
    public List<Trip> findByArrivalAirport(Airport arrivalAirport) throws TripNotFoundException {
        if (tripRepository.findByArrivalAirport(arrivalAirport).isEmpty()){
            throw new TripNotFoundException(arrivalAirport);
        }
        return tripRepository.findByArrivalAirport(arrivalAirport);
    }

    @Override
    public List<Trip> findByDepartureAirportAndArrivalAirport(Airport departureAirport, Airport arrivalAirport) throws TripNotFoundException {
        if (tripRepository.findByDepartureAirportAndArrivalAirport(departureAirport, arrivalAirport).isEmpty()){
            throw new TripNotFoundException(departureAirport, arrivalAirport);
        }
        return tripRepository.findByDepartureAirportAndArrivalAirport(departureAirport, arrivalAirport);
    }

    @Override
    public List<Trip> findByDepartureCityAndArrivalCity(City departureCity, City arrivalCity) throws TripNotFoundException {
        if (tripRepository.findByDepartureCityAndArrivalCity(departureCity, arrivalCity).isEmpty()){
            throw new TripNotFoundException(departureCity, arrivalCity);
        }
        return tripRepository.findByDepartureCityAndArrivalCity(departureCity, arrivalCity);
    }


}
