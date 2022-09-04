package com.pilgrims.travelagency.services.implementations;

import com.pilgrims.travelagency.exceptions.AuthorityNotFoundException;
import com.pilgrims.travelagency.models.Authority;
import com.pilgrims.travelagency.repositories.AuthorityRepository;
import com.pilgrims.travelagency.services.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of AuthorityService
 *
 * @author Ott Pikk
 */
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public void createAuthority(Authority authority) {
        authority.setActive(true);
        authorityRepository.save(authority);
    }

    @Override
    public Authority findAuthorityByName(String name) throws AuthorityNotFoundException {
        Optional<Authority> optionalAuthority = authorityRepository.findByName(name);

        if(optionalAuthority.isEmpty()) {
            throw new AuthorityNotFoundException(name);
        }
        return optionalAuthority.get();
    }

    @Override
    public List<Authority> findAllAuthorities() {
        return authorityRepository.findAll();
    }
}
