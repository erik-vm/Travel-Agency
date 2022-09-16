package com.pilgrims.travelagency.controllers;

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
    public List<Airport> findAllAirports() {
        return airportService.findAllAirports();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findAirportById(@PathVariable UUID id) {
        Airport airport = airportService.findAirportById(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(airport, headers, HttpStatus.OK);
    }

    @GetMapping("/{city}")
    public ResponseEntity<?> findAirportsByCity(@PathVariable City city) {
        List<Airport> list = airportService.findAirportsByCity(city);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(list, headers, HttpStatus.OK);
    }

    @GetMapping("/{country}")
    public ResponseEntity<?> findAirportsByCountry(@PathVariable Country country) {
        List<Airport> list = airportService.findAirportsByCountry(country);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(list, headers, HttpStatus.OK);
    }


    @GetMapping("/{name}")
    public ResponseEntity<?> findAirportsByName(@PathVariable String name) {
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
    public ResponseEntity<?> updateAirport(@PathVariable Airport airport) {
        airportService.updateAirport(airport);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteAirport(@PathVariable UUID id) {
        airportService.deleteAirportById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreAirport(@PathVariable UUID id) {
        airportService.restoreAirportById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

