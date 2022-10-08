package com.pilgrims.travelagency.controllers;

import com.pilgrims.travelagency.exceptions.TripNotFoundException;
import com.pilgrims.travelagency.models.*;
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
@RequestMapping("/trip/{id}")
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping
    public List<Trip> findAllTrips() throws TripNotFoundException {
        return tripService.findAllTrips();
    }

    @GetMapping("/id")
    public ResponseEntity<?> findTripById(@PathVariable UUID id) throws TripNotFoundException {
        Trip trip = tripService.findTripById(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(trip, headers, HttpStatus.OK);
    }

    @GetMapping("/promoted")
    public ResponseEntity<?> findPromotedTrips() throws TripNotFoundException {
        List <Trip> tripList = tripService.findByPromoted(true);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(tripList, headers, HttpStatus.OK);
    }

    @GetMapping("/departure_city/{id}")
    public ResponseEntity<?> findTripByDepartureCity(@PathVariable City city) throws TripNotFoundException {
        List <Trip> tripList = tripService.findByDepartureCity(city);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(tripList, headers, HttpStatus.OK);
    }

    @GetMapping("/arrival_city/{id}")
    public ResponseEntity<?> findTripByArrivalCity(@PathVariable City city) throws TripNotFoundException {
        List <Trip> tripList = tripService.findByArrivalCity(city);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(tripList, headers, HttpStatus.OK);
    }

    @GetMapping("/departure_city /arrival_city")
    public ResponseEntity<?> findTripByDepartureCityAndArrivalCity(@PathVariable City departureCity, @PathVariable City arrivalCity) throws TripNotFoundException {
        List <Trip> tripList = tripService.findByDepartureCityAndArrivalCity(departureCity, arrivalCity);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(tripList, headers, HttpStatus.OK);
    }
    @GetMapping("/departure_airport")
    public ResponseEntity<?> findTripByDepartureAirport(@PathVariable Airport airport) throws TripNotFoundException {
        List <Trip> tripList = tripService.findByDepartureAirport(airport);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(tripList, headers, HttpStatus.OK);
    }

    @GetMapping("/arrival_airport")
    public ResponseEntity<?> findTripByArrivalAirport(@PathVariable Airport airport) throws TripNotFoundException {
        List <Trip> tripList = tripService.findByArrivalAirport(airport);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(tripList, headers, HttpStatus.OK);
    }

    @GetMapping("/departure_airport /arrival_airport")
    public ResponseEntity<?> findTripByDepartureAirportAndArrivalAirport(@PathVariable Airport departureAirport, @PathVariable Airport arrivalAirport) throws TripNotFoundException {
        List <Trip> tripList = tripService.findByDepartureAirportAndArrivalAirport(departureAirport, arrivalAirport);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(tripList, headers, HttpStatus.OK);
    }

//    @GetMapping("/{duration}")
//    public ResponseEntity<?> findTripByDuration(@PathVariable double duration) {
//        List<Trip> trips = tripService.findTripsByDuration(duration);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setDate(new Date().toInstant());
//        return new ResponseEntity<>(trips, headers, HttpStatus.OK);
//    }
//
//    @GetMapping("/{country}")
//    public ResponseEntity<?> findTripByCountry(@PathVariable Country country) {
//        List<Trip> trips = tripService.findTripsByCountry(country);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setDate(new Date().toInstant());
//        return new ResponseEntity<>(trips, headers, HttpStatus.OK);
//    }
//
//    @GetMapping("/{continent}")
//    public ResponseEntity<?> findTripByContinent(@PathVariable Continent continent) {
//        List<Trip> trips = tripService.findTripByContinent(continent);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setDate(new Date().toInstant());
//        return new ResponseEntity<>(trips, headers, HttpStatus.OK);
//    }
//
//
//
//    @GetMapping("/{price}")
//    public ResponseEntity<?> findTripByPrice(@PathVariable double price) {
//        List<Trip> trips = tripService.findTripsByPrice(price);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setDate(new Date().toInstant());
//        return new ResponseEntity<>(trips, headers, HttpStatus.OK);
//    }



    @PostMapping
    public ResponseEntity<?> createTrip(@Valid @RequestBody Trip trip) {
        tripService.createTrip(trip);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateTrip(@RequestBody Trip trip) throws TripNotFoundException {
        tripService.updateTrip(trip);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteTrip(@PathVariable UUID id) throws TripNotFoundException {
        tripService.deleteTrip(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreTrip(@PathVariable UUID id) throws TripNotFoundException {
        tripService.restoreTrip(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
