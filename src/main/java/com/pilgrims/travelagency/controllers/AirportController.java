package com.pilgrims.travelagency.controllers;

import com.pilgrims.travelagency.exceptions.AirportNotFoundException;
import com.pilgrims.travelagency.models.*;
import com.pilgrims.travelagency.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Controller to handle airport related requests
 *
 * @author Kimmo Pormann
 */
@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping
    public List<Airport> findAllAirports() throws AirportNotFoundException {
        return airportService.findAllAirports();
    }

    @GetMapping("/id={id}")
    public ResponseEntity<?> findAirportById(@PathVariable UUID id) throws AirportNotFoundException {
        Airport airport = airportService.findAirportById(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(airport, headers, HttpStatus.OK);
    }

    @GetMapping("/city")
    public ResponseEntity<?> findAirportsByCity(@RequestBody City city) throws AirportNotFoundException {
        List<Airport> list = airportService.findAirportsByCity(city);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(list, headers, HttpStatus.OK);
    }




    @GetMapping("/name={name}")
    public ResponseEntity<?> findAirportsByName(@PathVariable String name) throws AirportNotFoundException {
        Airport airport = airportService.findAirportByName(name);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(airport, headers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createAirport(@Valid @RequestBody Airport airport) {
        airportService.createAirport(airport);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateAirport(@RequestBody Airport airport) throws AirportNotFoundException {
        airportService.updateAirport(airport);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/id={id}")
    public ResponseEntity<?> deleteAirport(@PathVariable UUID id) throws AirportNotFoundException {
        airportService.deleteAirportById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/id={id}")
    public ResponseEntity<?> restoreAirport(@PathVariable UUID id) throws AirportNotFoundException {
        airportService.restoreAirportById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

