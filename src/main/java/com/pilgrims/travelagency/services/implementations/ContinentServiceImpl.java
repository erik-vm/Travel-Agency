package com.pilgrims.travelagency.services.implementations;

import com.pilgrims.travelagency.models.City;
import com.pilgrims.travelagency.models.Continent;

import com.pilgrims.travelagency.repositories.ContinentRepository;
import com.pilgrims.travelagency.services.ContinentService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Implementation of CountryService
 *
 * @author Kimmo Pormann
 */

@Service
@Transactional
public class ContinentServiceImpl implements ContinentService {


    private ContinentRepository continentRepository;

    @Override
    public void createContinent(Continent continent) {
        continent.setActive(true);
        continentRepository.save(continent);

    }

    @Override
    public Continent findContinentByName(String name) {
        return null;
    }

    @Override
    public Continent findContinentById(UUID id) {
        return null;
    }

    @Override
    public List<Continent> findAllContinents() {
        return null;
    }

    @Override
    public void saveContinent(Continent continent) {

    }


    public List<Continent> findContinentsByCity(City city) {
        return null;
    }


    public Continent findContinentsByName(String name) {
        Optional<Continent> optionalContinent = continentRepository.findByName(name);
        return optionalContinent.get();
    }


    public void updateContinent(Continent continent) {
        if (findContinentById(continent.getId()) != null) {
            continentRepository.saveAndFlush(continent);
        }
    }

    public Continent findContinentsById(UUID id) {
        Optional<Continent> optionalContinents = continentRepository.findById(id);

        return null;
    }
}