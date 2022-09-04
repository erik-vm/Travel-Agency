package com.pilgrims.travelagency.services;

import com.pilgrims.travelagency.exceptions.AuthorityNotFoundException;
import com.pilgrims.travelagency.models.Authority;

import java.util.List;

/**
 * Service to handle authority related operations
 *
 * @author Ott Pikk
 */

public interface AuthorityService {

    /**
     * To create a new authority
     *
     * @param authority Authority
     */
    void createAuthority(Authority authority);

    /**
     * To find authority by name
     *
     * @param name Authority name
     * @return optional of Authority
     */
    Authority findAuthorityByName(String name) throws AuthorityNotFoundException;

    /**
     * To find all authorities
     *
     * @return list of authorities
     */
    List<Authority> findAllAuthorities();
}
