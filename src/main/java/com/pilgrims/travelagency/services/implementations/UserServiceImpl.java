package com.pilgrims.travelagency.services.implementations;

import com.pilgrims.travelagency.models.User;
import com.pilgrims.travelagency.repositories.UserRepository;
import com.pilgrims.travelagency.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Autowired
    private Base64.Encoder base64Encoder;


    @Override
    public void createUser(User user) {
        user.setPassword(base64Encoder.encodeToString(user.getPassword().getBytes()));
        user.setActive(true);
        userRepository.save(user);

    }

    @Override
    public User findUserByUserName(String userName) {
        Optional<User> optionalUser = userRepository.findByUserName(userName);
        return optionalUser.get();
    }

    @Override
    public User findUserById(UUID id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    @Override
    public User findByUserNameAndPassword(String userName, String password) {
        Optional<User> optionalUser = userRepository.findByUserNameAndPassword(userName, password);
        return null;
    }

    @Override
    public List<User> findAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public void updateUser(User user) {
        if (findUserById(user.getId()) != null) {
            userRepository.saveAndFlush(user);
        }
    }
}
