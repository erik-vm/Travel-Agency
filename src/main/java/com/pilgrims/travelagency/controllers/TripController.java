package com.pilgrims.travelagency.controllers;

import com.pilgrims.travelagency.models.Hotel;
import com.pilgrims.travelagency.models.Trip;
import com.pilgrims.travelagency.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Controller to handle trip related requests
 *
 * @author Ott Pikk
 */

@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping
    public List<Trip> findAllTrips() {
        return tripService.findAllTrips();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findTripById(@PathVariable UUID id) {
        Trip trip = tripService.findTripById(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(trip, headers, HttpStatus.OK);
    }

    @GetMapping("/{duration}")
    public ResponseEntity<?> findTripByDuration(@PathVariable double duration) {
        List<Trip> trips = tripService.findTripsByDuration(duration);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(trips, headers, HttpStatus.OK);
    }

    @GetMapping("/{price}")
    public ResponseEntity<?> findTripByPrice(@PathVariable double price) {
        List<Trip> trips = tripService.findTripsByPrice(price);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(trips, headers, HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<?> createTrip(@Valid @RequestBody Trip trip) {
        tripService.createTrip(trip);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateTrip(@PathVariable Trip trip) {
        tripService.updateTrip(trip);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteTrip(@PathVariable UUID id) {
        tripService.deleteTrip(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreTrip(@PathVariable UUID id) {
        tripService.restoreTrip(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
