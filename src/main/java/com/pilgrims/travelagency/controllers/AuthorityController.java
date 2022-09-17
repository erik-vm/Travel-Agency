package com.pilgrims.travelagency.controllers;

import com.pilgrims.travelagency.exceptions.AuthorityNotFoundException;
import com.pilgrims.travelagency.exceptions.UserNotFoundException;
import com.pilgrims.travelagency.models.Authority;
import com.pilgrims.travelagency.models.Login;
import com.pilgrims.travelagency.models.User;
import com.pilgrims.travelagency.services.AuthorityService;
import com.pilgrims.travelagency.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Controller to handle authority related requests
 *
 * @author Kimmo Pormann
 */
@RestController
@RequestMapping("/users")
public class AuthorityController {
    @Autowired
    public AuthorityService authorityService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findAuthorityById(@PathVariable UUID id) {
        Authority authority = authorityService.findAuthorityById(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(authority, headers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createAuthority(@RequestBody Authority authority) throws AuthorityNotFoundException {
        authorityService.createAuthority(authority);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }




}

