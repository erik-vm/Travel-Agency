package com.pilgrims.travelagency.exceptions;

/**
 * Exception for user not found
 *
 * @author Ott Pikk
 */
public class UserNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String userName) {
        super(String.format("User not found for name=%s!", userName));
    }

    public UserNotFoundException(String userName, String password) {
        super(String.format("User not found for name=%s and the given password!", userName ));
    }
}
