package com.pilgrims.travelagency.controllers;

import com.pilgrims.travelagency.models.City;
import com.pilgrims.travelagency.models.Country;
import com.pilgrims.travelagency.models.Hotel;
import com.pilgrims.travelagency.models.HotelStandard;
import com.pilgrims.travelagency.services.HotelService;
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
 * Controller to handle hotel related requests
 *
 * @author Ott Pikk
 */
@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping
    public List<Hotel> findAllHotels() {
        return hotelService.findAllHotels();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findHotelById(@PathVariable UUID id) {
        Hotel hotel = hotelService.findHotelById(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(hotel, headers, HttpStatus.OK);
    }

    @GetMapping("/{city}")
    public ResponseEntity<?> findHotelsByCity(@PathVariable City city) {
        List<Hotel> list = hotelService.findHotelsByCity(city);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(list, headers, HttpStatus.OK);
    }

  /*  @GetMapping("/{country}")
    public ResponseEntity<?> findHotelsByCountry(@PathVariable Country country) {
        List<Hotel> list = hotelService.findHotelsByCountry(country);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(list, headers, HttpStatus.OK);
    } */

    @GetMapping("/{standard}")
    public ResponseEntity<?> findHotelsByStandard(@PathVariable HotelStandard standard) {
        List<Hotel> list = hotelService.findHotelsByStandard(standard);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(list, headers, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> findHotelsByName(@PathVariable String name) {
        Hotel hotel = hotelService.findHotelByName(name);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(hotel, headers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createHotel(@Valid @RequestBody Hotel hotel) {
        hotelService.createHotel(hotel);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateHotel(@PathVariable Hotel hotel) {
        hotelService.updateHotel(hotel);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable UUID id) {
        hotelService.deleteHotelById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreHotel(@PathVariable UUID id) {
        hotelService.restoreHotelById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
