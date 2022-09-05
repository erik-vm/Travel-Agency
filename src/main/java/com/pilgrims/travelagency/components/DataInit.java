package com.pilgrims.travelagency.components;

import com.github.javafaker.Faker;
import com.pilgrims.travelagency.exceptions.AuthorityNotFoundException;
import com.pilgrims.travelagency.models.Authority;
import com.pilgrims.travelagency.models.User;
import com.pilgrims.travelagency.services.AuthorityService;
import com.pilgrims.travelagency.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.ZoneId;

import static com.pilgrims.travelagency.utils.Constants.Security.*;

/**
 * Component to initialize data on app startup
 *
 * @author Ott Pikk
 */
@Component
public class DataInit {

    /**
     * @Autowired private AuthorityService authorityService;
     */

    @Autowired
    private UserService userService;
    @Autowired
    private AuthorityService authorityService;

   private Faker faker = new Faker();

    @PostConstruct
    public void init() throws AuthorityNotFoundException {
        initAuthorityData();
        initUserData();
        populateDBWithUsers();
    }

    // PRIVATE METHODS //


      private void initAuthorityData() {
      System.out.println("Starting initializing Authority..");
      Authority authorityAdmin = new Authority();
      authorityAdmin.setName(AUTHORITY_ADMIN);
          authorityService.createAuthority(authorityAdmin);

      Authority authorityCustomer = new Authority();
      authorityCustomer.setName(AUTHORITY_CUSTOMER);
      authorityService.createAuthority(authorityCustomer);

      Authority authorityGuest = new Authority();
      authorityGuest.setName(AUTHORITY_GUEST);
      authorityService.createAuthority(authorityGuest);
      }


    private void initUserData() throws AuthorityNotFoundException {
        System.out.println("Starting initializing User..");
        User user = new User();
        user.setUserName("test");
        user.setPassword("test");
        user.setActive(true);
        user.setAddress("Linn 1, Tänav 2, maja ja korter");
        user.setEmail("suvaline@domeen.com");
        user.setAuthority(authorityService.findAuthorityByName(AUTHORITY_ADMIN));

        try {
            userService.createUser(user);
            System.out.println("User " + user.getUserName() + " created successfully");

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * private void createAuthority(Authority authority) {
     * try {
     * Authority resultAuthority = authorityService.findAuthorityByName(authority.getName());
     * System.out.println("Cannot pre-initialize authority:" + resultAuthority.getName());
     * } catch (AuthorityNotFoundException authorityNotFoundException) {
     * authorityService.createAuthority(authority);
     * }
     * }
     */

    private void populateDBWithUsers() throws AuthorityNotFoundException {


        for (int i = 0; i < 30; i++) {
            User user = new User();
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@sda.com", firstName, lastName);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setUserName(email);
            user.setPhoneNumber(faker.phoneNumber().toString());
            user.setActive(true);
            user.setAddress(faker.address().streetAddress()  + ", " + faker.address().cityName());
            user.setAuthority(authorityService.findAuthorityByName(AUTHORITY_CUSTOMER));
            user.setPassword("password");
            user.setDateOfBirth(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            userService.createUser(user);
        }
    }
}
