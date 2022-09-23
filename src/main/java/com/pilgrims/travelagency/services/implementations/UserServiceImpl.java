package com.pilgrims.travelagency.services.implementations;

import com.pilgrims.travelagency.exceptions.AuthorityNotFoundException;
import com.pilgrims.travelagency.exceptions.UserNotFoundException;
import com.pilgrims.travelagency.models.User;
import com.pilgrims.travelagency.repositories.UserRepository;
import com.pilgrims.travelagency.services.AuthorityService;
import com.pilgrims.travelagency.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.pilgrims.travelagency.utils.Constants.Security.AUTHORITY_CUSTOMER;

/**
 * Implementation of UserService
 *
 * @author Ott Pikk
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Base64.Encoder base64Encoder;


    @Override
    public void createUser(User user) throws AuthorityNotFoundException {
        user.setAuthority(authorityService.findAuthorityByName(AUTHORITY_CUSTOMER));
        user.setUserName(user.getEmail());
        user.setPassword(base64Encoder.encodeToString(user.getPassword().getBytes()));
        user.setActive(true);
        userRepository.save(user);
    }

    @Override
    public User findUserByUserName(String userName) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findByUserName(userName);
        if (optionalUser.isEmpty()){
            throw new UserNotFoundException(userName);
        }
        return optionalUser.get();
    }

    @Override
    public User findUserById(UUID id) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()){
            throw new UserNotFoundException(id);
        }
        return optionalUser.get();
    }

    @Override
    public User findByUserNameAndPassword(String userName, String password) throws UserNotFoundException {
        String encodedPassword = base64Encoder.encodeToString(password.getBytes());
        Optional<User> optionalUser = userRepository.findByUserNameAndPassword(userName, encodedPassword);

        if(optionalUser.isEmpty()) {
            throw new UserNotFoundException(userName, password);
        }

        return optionalUser.get();
    }

    @Override
    public List<User> findAllUsers() throws UserNotFoundException {
        if (userRepository.findAll().isEmpty()){
            throw new UserNotFoundException();
        }
        return userRepository.findAll();
    }

    @Override
    public void updateUser(User user) throws UserNotFoundException {
        if (findUserById(user.getId()) != null) {
            userRepository.saveAndFlush(user);
        }
    }
}
