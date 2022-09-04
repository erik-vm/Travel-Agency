package com.pilgrims.travelagency.services;

import com.pilgrims.travelagency.models.User;
import java.util.List;
import java.util.UUID;

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
     * To find User by its ID
     * @param id id of user
     * @return User
     */
    User findUserById(UUID id);


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

    /**
     * To update an existing User
     * @param user user
     */
    void updateUser (User user);
}
