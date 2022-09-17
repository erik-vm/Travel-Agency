package com.pilgrims.travelagency.services.implementations;

import com.pilgrims.travelagency.exceptions.ContinentNotFoundException;
import com.pilgrims.travelagency.models.City;
import com.pilgrims.travelagency.models.Continent;

import com.pilgrims.travelagency.repositories.ContinentRepository;
import com.pilgrims.travelagency.services.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    private ContinentRepository continentRepository;

    @Override
    public void createContinent(Continent continent) {
        continent.setActive(true);
        continentRepository.save(continent);

    }

    @Override
    public Continent findContinentByName(String name) throws ContinentNotFoundException {
        Optional<Continent> optionalContinent = continentRepository.findByName(name);
        if (optionalContinent.isEmpty()){
            throw new ContinentNotFoundException(name);
        }
        return optionalContinent.get();
    }

    @Override
    public Continent findContinentById(UUID id) {
        return null;
    }

    @Override
    public List<Continent> findAllContinents() {
        return null;
    }

}
