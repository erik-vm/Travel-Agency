package com.pilgrims.travelagency.services.implementations;

import com.pilgrims.travelagency.models.City;
import com.pilgrims.travelagency.models.Continent;
import com.pilgrims.travelagency.models.Country;
import com.pilgrims.travelagency.repositories.CountryRepository;
import com.pilgrims.travelagency.services.CountryService;
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
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public void createCountry(Country country) {
        country.setActive(true);
        countryRepository.save(country);

    }

    @Override
    public List<Country> findCountriesByCity(City city) {
        return null;
    }

    @Override
    public Country findCountryByName(String name) {
        Optional<Country> optionalCountry = countryRepository.findByName(name);
        return optionalCountry.get();
    }



    @Override
    public void updateCountry(Country country) {
        if (findCountryById(country.getId()) != null) {
            countryRepository.saveAndFlush(country);
        }
    }

    public Country findCountryById (UUID id) {
        Optional<Country> optionalCountry = countryRepository.findById(id);
        return optionalCountry.get();
    }

    @Override
    public List<Country> findAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public void deleteCountryById(UUID id) {
        Country country = findCountryById(id);
        country.setActive(false);
        countryRepository.saveAndFlush(country);
    }

    @Override
    public void restoreCountryById(UUID id) {
        Country country = findCountryById(id);
        country.setActive(true);
        countryRepository.saveAndFlush(country);

    }

    @Override
    public List<Country> findAllCountriesByContinent(Continent continent) {
        return countryRepository.findAllByContinent(continent);
    }


}
