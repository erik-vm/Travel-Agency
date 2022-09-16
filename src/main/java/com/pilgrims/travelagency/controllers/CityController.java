package com.pilgrims.travelagency.controllers;

import com.pilgrims.travelagency.models.*;
import com.pilgrims.travelagency.services.AirportService;
import com.pilgrims.travelagency.services.CityService;
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
 * Controller to handle city related requests
 *
 * @author Kimmo Pormann
 */
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> findAllCities() {
        return cityService.findAllCities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCityById(@PathVariable UUID id) {
        City city = cityService.findCityById(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(city, headers, HttpStatus.OK);
    }


    @GetMapping("/{country}")
    public ResponseEntity<?> findCitiesByCountry(@PathVariable Country country) {
        List<City> list = cityService.findCitiesByCountry(country);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(list, headers, HttpStatus.OK);
    }


    @GetMapping("/{name}")
    public ResponseEntity<?> findCitiesByName(@PathVariable String name) {
        City city = cityService.findCityByName(name);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(city, headers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCity(@Valid @RequestBody City city) {
        cityService.createCity(city);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateCity(@PathVariable City city) {
        cityService.updateCity(city);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable UUID id) {
        cityService.deleteCityById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreCity(@PathVariable UUID id) {
        cityService.restoreCityById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

