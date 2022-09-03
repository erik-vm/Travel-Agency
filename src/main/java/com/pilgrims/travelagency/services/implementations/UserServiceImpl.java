package com.pilgrims.travelagency.services.implementations;

import com.pilgrims.travelagency.models.User;
import com.pilgrims.travelagency.repositories.UserRepository;
import com.pilgrims.travelagency.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of UserService
 *
 * @author Ott Pikk
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void createUser(User user) {

    }

    @Override
    public User findUserByUserName(String userName) {
        return null;
    }

    @Override
    public User findByUserNameAndPassword(String userName, String password) {
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }
}
