package com.pilgrims.travelagency.repositories;

import com.pilgrims.travelagency.models.Hotel;
import com.sun.xml.bind.api.impl.NameConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
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
    List<Hotel> findByCity(City city);
    List<Hotel> findByCountry(Country country);
    List<Hotel> findByStandard(String standard);


}
