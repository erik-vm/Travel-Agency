package com.pilgrims.travelagency.repositories;

import com.pilgrims.travelagency.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * REpoitory to handle hotel related DB operations
 *
 * @author Ott Pikk
 */

@Repository
public interface HotelRepository extends JpaRepository<Hotel, UUID> {
    Optional<Hotel> findByName(String name);
    public Optional<Hotel> findByCity(City city);
}
