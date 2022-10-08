package com.pilgrims.travelagency.controllers;

import com.pilgrims.travelagency.exceptions.CountryNotFoundException;
import com.pilgrims.travelagency.models.*;
import com.pilgrims.travelagency.services.CountryService;
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
 * Controller to handle country related requests
 *
 * @author Kimmo Pormann
 */
@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> findAllCountries() throws CountryNotFoundException {
        return countryService.findAllCountries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCountryById(@PathVariable UUID id) throws CountryNotFoundException {
        Country country = countryService.findCountryById(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(country, headers, HttpStatus.OK);
    }


    @GetMapping("/continent")
    public ResponseEntity<?> findCountryByContinent(@RequestBody Continent continent) throws CountryNotFoundException {
        List<Country> list = countryService.findAllCountriesByContinent(continent);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(list, headers, HttpStatus.OK);
    }


    @GetMapping("/find-by-name")
    public ResponseEntity<?> findCountryByName(@RequestParam(name="name") String name) throws CountryNotFoundException {
        Country country = countryService.findCountryByName(name);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(country, headers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCountry(@Valid @RequestBody Country country) {
        countryService.createCountry(country);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateCountry(@RequestBody Country country) throws CountryNotFoundException {
        countryService.updateCountry(country);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteCountry(@PathVariable UUID id) throws CountryNotFoundException {
        countryService.deleteCountryById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreCountry(@PathVariable UUID id) throws CountryNotFoundException {
        countryService.restoreCountryById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
