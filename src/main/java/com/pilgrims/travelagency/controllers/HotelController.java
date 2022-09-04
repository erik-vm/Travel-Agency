package com.pilgrims.travelagency.controllers;

import com.pilgrims.travelagency.models.Hotel;
import com.pilgrims.travelagency.services.HotelService;
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
}
