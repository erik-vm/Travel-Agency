package com.pilgrims.travelagency.repositories;

import com.pilgrims.travelagency.models.Airport;
import com.pilgrims.travelagency.models.City;
import com.pilgrims.travelagency.models.Hotel;
import com.pilgrims.travelagency.models.HotelStandard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AirportRepository extends JpaRepository<Airport, UUID> {
    Optional<Airport> findByName(String name);





}