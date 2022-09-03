package com.pilgrims.travelagency.services;

import com.pilgrims.travelagency.models.User;

import java.util.List;

/**
 * Service to handle user related operations
 *
 * @author Ott Pikk
 */

public interface UserService {
    /**
     * To create a new User
     *
     * @param user User
     */
    void createUser(User user);

    /**
     * To find User by userName
     *
     * @param userName userName
     * @return User
     */
    User findUserByUserName(String userName);

    /**
     * To find User by userName and password
     *
     * @author Ott Pikk
     */
    User findByUserNameAndPassword(String userName, String password);

    /** To find all Users
     *
     * @return list of all Users
     */
    List<User> findAllUsers();
}
