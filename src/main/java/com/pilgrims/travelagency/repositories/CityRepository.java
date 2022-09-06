package com.pilgrims.travelagency.repositories;

import com.pilgrims.travelagency.models.City;
import com.pilgrims.travelagency.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CityRepository extends JpaRepository<City, UUID> {
    Optional<City> findByName(String name);



}