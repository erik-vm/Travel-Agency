package com.pilgrims.travelagency.controllers;

import com.pilgrims.travelagency.exceptions.ContinentNotFoundException;
import com.pilgrims.travelagency.models.Continent;
import com.pilgrims.travelagency.services.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Controller to handle continent related requests
 *
 * @author Erik Vainumäe
 */

@RestController
@RequestMapping("/continent")
public class ContinentController {

    @Autowired
    private ContinentService continentService;

    @GetMapping
    public List<Continent> getAllContinents() throws ContinentNotFoundException {
        return continentService.findAllContinents();
    }

    @GetMapping("/id={id}")
    ResponseEntity<?> findContinentById(@PathVariable UUID id) throws ContinentNotFoundException {
        Continent continent = continentService.findContinentById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(continent, headers, HttpStatus.OK);
    }

    @GetMapping("/name={continentName}")
    ResponseEntity<?> findContinentByName(@PathVariable String continentName) throws ContinentNotFoundException {
        Continent continent = continentService.findContinentByName(continentName);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(continent, headers, HttpStatus.OK);
    }
}
