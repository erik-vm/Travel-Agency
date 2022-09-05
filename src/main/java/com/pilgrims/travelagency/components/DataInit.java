package com.pilgrims.travelagency.components;

import com.github.javafaker.Faker;
import com.pilgrims.travelagency.models.Authority;
import com.pilgrims.travelagency.models.User;
import com.pilgrims.travelagency.services.AuthorityService;
import com.pilgrims.travelagency.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.ZoneId;

import static com.pilgrims.travelagency.utils.Constants.Security.AUTHORITY_ADMIN;

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


    @PostConstruct
    public void init() {
        //initAuthorityData();
        //   initUserData();
        populateDBWithUsers();
    }

    // PRIVATE METHODS //

    /**
     * private void initAuthorityData() {
     * System.out.println("Starting initializing Authority..");
     * Authority authorityAdmin = new Authority();
     * authorityAdmin.setName(AUTHORITY_ADMIN);
     * createAuthority(authorityAdmin);
     * <p>
     * Authority authorityCustomer = new Authority();
     * authorityCustomer.setName(AUTHORITY_CUSTOMER);
     * createAuthority(authorityCustomer);
     * <p>
     * Authority authorityGuest = new Authority();
     * authorityGuest.setName(AUTHORITY_GUEST);
     * createAuthority(authorityGuest);
     * }
     */

    private void initUserData() {
        System.out.println("Starting initializing User..");
        Authority authority = new Authority();
        authority.setName(AUTHORITY_ADMIN);
        User user = new User();
        user.setUserName("test");
        user.setPassword("test");
        user.setActive(true);
        user.setAddress("Linn 1, Tänav 2, maja ja korter");
        user.setEmail("suvaline@domeen.com");
        user.setAuthority(authority);

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

    private void populateDBWithUsers() {
        Faker faker = new Faker();
        //   Authority authority = new Authority();
        //  authority.setName(AUTHORITY_CUSTOMER);
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
            user.setAddress(faker.address().streetAddress() + ", " + faker.address().streetAddressNumber() + ", " + faker.address().cityName());
            // user.setAuthority(authority);
            user.setPassword("password");
            user.setDateOfBirth(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            userService.createUser(user);
        }
    }
}
