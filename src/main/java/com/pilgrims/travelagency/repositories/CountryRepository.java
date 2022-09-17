package com.pilgrims.travelagency.repositories;

import com.pilgrims.travelagency.models.Continent;
import com.pilgrims.travelagency.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CountryRepository extends JpaRepository<Country, UUID> {
    Optional<Country> findByName(String name);

    List<Country> findAllByContinent(Continent continent);



}
