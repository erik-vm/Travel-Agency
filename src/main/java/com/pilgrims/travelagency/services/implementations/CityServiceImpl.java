package com.pilgrims.travelagency.services.implementations;

import com.pilgrims.travelagency.exceptions.CityNotFoundException;
import com.pilgrims.travelagency.models.City;
import com.pilgrims.travelagency.models.Country;
import com.pilgrims.travelagency.repositories.CityRepository;
import com.pilgrims.travelagency.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Implementation of CityService
 *
 * @author Kimmo Pormann
 */

@Service
@Transactional
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public void createCity(City city) {
        city.setActive(true);
        cityRepository.save(city);

    }
    public List<City> findCitiesByCountry(Country country) {
        return cityRepository.findByCountry(country);
    }


    @Override
    public City findCityByName(String name) throws CityNotFoundException {
        Optional<City> optionalCity = cityRepository.findByName(name);
        if (optionalCity.isEmpty()){
            throw new CityNotFoundException(name);
        }
        return optionalCity.get();
    }

    @Override
    public void updateCity(City city) throws CityNotFoundException {
        if (findCityById(city.getId()) != null) {
            cityRepository.saveAndFlush(city);
        }
    }

    public City findCityById (UUID id) throws CityNotFoundException {
        Optional<City> optionalCity = cityRepository.findById(id);
        if (optionalCity.isEmpty()){
            throw new CityNotFoundException(id);
        }
        return optionalCity.get();
    }

    @Override
    public List<City> findAllCities() throws CityNotFoundException {
        if (cityRepository.findAll().isEmpty()){
            throw new CityNotFoundException();
        }
        return cityRepository.findAll();
    }

    @Override
    public void deleteCityById(UUID id) throws CityNotFoundException {
        City city = findCityById(id);
        city.setActive(false);
        cityRepository.saveAndFlush(city);
    }

    @Override
    public void restoreCityById(UUID id) throws CityNotFoundException {
        City city = findCityById(id);
        city.setActive(true);
        cityRepository.saveAndFlush(city);

    }
}
