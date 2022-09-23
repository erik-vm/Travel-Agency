package com.pilgrims.travelagency.exceptions;

import java.util.UUID;

/**
 * Exception for user not found
 *
 * @author Ott Pikk
 */
public class UserNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public UserNotFoundException() {
        super("Users not found!");
    }

    public UserNotFoundException(UUID uuid) {
        super(String.format("User not found with id=%s!", uuid));
    }
    public UserNotFoundException(String userName) {
        super(String.format("User not found for name=%s!", userName));
    }

    public UserNotFoundException(String userName, String password) {
        super(String.format("User not found for name=%s and the given password!", userName ));
    }
}
