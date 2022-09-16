package com.pilgrims.travelagency.repositories;

import com.pilgrims.travelagency.models.Continent;
import com.pilgrims.travelagency.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContinentRepository extends JpaRepository<Continent, UUID> {
    Optional<Continent> findByName(String name);


}