package com.pilgrims.travelagency.services.implementations;

import com.pilgrims.travelagency.models.*;
import com.pilgrims.travelagency.repositories.AirportRepository;
import com.pilgrims.travelagency.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Implementation of AirportService
 *
 * @author Kimmmo Pormann
 */

@Service
@Transactional
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public void createAirport(Airport airport) {
        airport.setActive(true);
        airportRepository.save(airport);

    }

    @Override
    public List<Airport> findAirportsByCity(City city) {
        return airportRepository.findByCity(city);
    }

    @Override
    public List<Airport> findAirportsByCountry(Country country) {
        return null;
    }

    @Override
    public Airport findAirportByName(String name) {
        Optional<Airport> optionalAirport = airportRepository.findByName(name);
        return optionalAirport.get();
    }

    @Override
    public void updateAirport(Airport airport) {
        if (findAirportById(airport.getId()) != null) {
            airportRepository.saveAndFlush(airport);
        }
    }

    public Airport findAirportById (UUID id) {
        Optional<Airport> optionalAirport = airportRepository.findById(id);
        return optionalAirport.get();
    }

    @Override
    public List<Airport> findAllAirports() {
        return airportRepository.findAll();
    }

    @Override
    public void deleteAirportById(UUID id) {
        Airport airport = findAirportById(id);
        airport.setActive(false);
        airportRepository.saveAndFlush(airport);
    }

    @Override
    public void restoreAirportById(UUID id) {
        Airport airport = findAirportById(id);
        airport.setActive(true);
        airportRepository.saveAndFlush(airport);

    }
}