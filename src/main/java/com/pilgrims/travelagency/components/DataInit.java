package com.pilgrims.travelagency.components;

import com.github.javafaker.Faker;
import com.pilgrims.travelagency.exceptions.AuthorityNotFoundException;
import com.pilgrims.travelagency.exceptions.ContinentNotFoundException;
import com.pilgrims.travelagency.exceptions.HotelNotFoundException;
import com.pilgrims.travelagency.models.*;
import com.pilgrims.travelagency.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.pilgrims.travelagency.models.HotelBasis.*;
import static com.pilgrims.travelagency.models.HotelStandard.*;
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

    @Autowired
    private ContinentService continentService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private CityService cityService;

    @Autowired
    private AirportService airportService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private TripService tripService;

    private Faker faker = new Faker();

    @PostConstruct
    public void init() throws AuthorityNotFoundException, ContinentNotFoundException, HotelNotFoundException {
//        initAuthorityData();
//        initUserData();
//        populateDBWithUsers();
//        populateDBWithContinents();
//        populateDBWithCountries();
//        populateDBWithCities();
//        populateDBWithAirports();
//        populateDBWithHotels();
        populateDBWithTrips();
    }

    // PRIVATE METHODS //


    private void initAuthorityData() {
        System.out.println("Starting initializing Authority..");
        Authority authorityAdmin = new Authority();
        authorityAdmin.setName(AUTHORITY_ADMIN);
        authorityService.createAuthority(authorityAdmin);
        System.out.println("Successfully initialized Authority: ADMIN");

        Authority authorityCustomer = new Authority();
        authorityCustomer.setName(AUTHORITY_CUSTOMER);
        authorityService.createAuthority(authorityCustomer);
        System.out.println("Successfully initialized Authority: CUSTOMER");

        Authority authorityGuest = new Authority();
        authorityGuest.setName(AUTHORITY_GUEST);
        authorityService.createAuthority(authorityGuest);
        System.out.println("Successfully initialized Authority: GUEST");
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
            String email = String.format("%s.%s@sda.com", firstName, lastName).toLowerCase();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPhoneNumber(faker.phoneNumber().toString());
            user.setActive(true);
            user.setAddress(faker.address().streetAddress() + ", " + faker.address().cityName());
            user.setAuthority(authorityService.findAuthorityByName(AUTHORITY_CUSTOMER));
            user.setPassword("password");
            user.setDateOfBirth(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            userService.createUser(user);
        }
    }

    private void populateDBWithContinents() {
        String[] continents = {"Africa", "Asia", "Antarctica", "Australia and Oceania", "Europe", "North America", "South America"};
        for (String s : continents) {
            Continent continent = new Continent();
            continent.setName(s);
            continent.setActive(true);
            continentService.createContinent(continent);
        }
    }

    private void populateDBWithCountries() {
        String[] europeCountries = {"Albania", "Andorra", "Armenia", "Austria", "Azerbaijan", "Belarus", "Belgium Bosnia and Herzegovina", "Bulgaria,", "Croatia", "Cyprus",
                "Czechia", "Denmark", "Estonia", "Finland", "France", "Georgia", "Germany", "Greece", "Hungary", "Iceland", "Ireland", "Italy", "Kazakhstan", "Kosovo", "Latvia",
                "Liechtenstein", "Lithuania", "Luxembourg", "Malta", "Moldova", "Monaco", "Montenegro", "Netherlands", "North Macedonia", "Norway", "Poland", "Portugal",
                "Romania", "Russia", "San Marino", "Serbia", "Slovakia", "Slovenia", "Spain", "Sweden", "Switzerland", "Turkey", "Ukraine", "United Kingdom (UK)",
                "Vatican City (Holy See)"};


        String[] asianCountries = {"Afghanistan", "Armenia", "Azerbaijan", "Bahrain", "Bangladesh", "Bhutan", "Brunei", "Cambodia", "China", "Cyprus", "Georgia", "India", "Indonesia", "Iran",
                "Iraq", "Israel", "Japan", "Jordan", "Kazakhstan", "Kuwait", "Kyrgyzstan", "Laos", "Lebanon", "Malaysia", "Maldives", "Mongolia", "Myanmar", "Nepal", "North Korea",
                "Oman", "Pakistan", "Palestine", "Philippines", "Qatar", "Russia", "Saudi Arabia", "Singapore", "South Korea", "Sri Lanka", "Syria", "Taiwan",
                "Tajikistan", "Thailand", "Timor-Leste", "Turkey", "Turkmenistan", "United Arab Emirates (UAE)", "Uzbekistan", "Vietnam", "Yemen"};

        String[] africanCountries = {"Algeria", "Angola", "Benin", "Botswana", "Burkina Faso", "Burundi", "Cabo Verde", "Cameroon",
                "Central African Republic (CAR)", "Chad", "Comoros", "Congo, Democratic Republic of the", "Congo, Republic of the", "Cote d'Ivoire", "Djibouti", "Egypt",
                "Equatorial Guinea", "Eritrea", "Eswatini", "Ethiopia", "Gabon", "Gambia", "Ghana", "Guinea", "Guinea-Bissau", "Kenya", "Lesotho", "Liberia", "Libya", "Madagascar",
                "Malawi", "Mali", "Mauritania", "Mauritius", "Morocco", "Mozambique", "Namibia", "Niger", "Nigeria", "Rwanda", "Sao Tome and Principe", "Senegal", "Seychelles",
                "Sierra Leone", "Somalia", "South Africa", "South Sudan", "Sudan", "Tanzania", "Togo", "Tunisia", "Uganda", "Zambia", "Zimbabwe"};

        String[] northAmericaCountries = {"Antigua and Barbuda", "Bahamas", "Barbados", "Belize", "Canada", "Costa Rica", "Cuba",
                "Dominica", "Dominican Republic", "El Salvador", "Grenada", "Guatemala", "Haiti", "Honduras", "Jamaica", "Mexico", "Nicaragua",
                "Panama", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Trinidad and Tobago", "United States of America (USA)",
                "Anguilla (UK)", "Aruba (Netherlands)", "Bermuda (UK)", "Bonaire (Netherlands)", "British Virgin Islands (UK)", "Cayman Islands (UK)", "Clipperton Island (France)",
                "Curacao (Netherlands)", "Greenland (Denmark)", "Guadeloupe (France)", "Martinique (France)", "Montserrat (UK)", "Navassa Island (USA)", "Puerto Rico (USA)",
                "Saba (Netherlands)", "Saint Barthelemy (France)", "Saint Martin (France)", "Saint Pierre and Miquelon (France)", "Sint Eustatius (Netherlands)",
                "Sint Maarten (Netherlands)", "Turks and Caicos Islands (UK)", "US Virgin Islands (USA)"};

        String[] southAmericaCountries = {"Argentina", "Bolivia", "Brazil", "Chile", "Colombia", "Ecuador", "Guyana", "Paraguay", "Peru", "Suriname",
                "Uruguay", "Venezuela", "Falkland Islands (UK)", "French Guiana (France)", "South Georgia and the South Sandwich Islands (UK)"};

        String[] australiaAndOceaniaCountries = {"Australia", "Fiji", "Kiribati", "Marshall Islands", "Micronesia", "Nauru", "New Zealand", "Palau", "Papua New Guinea",
                "Samoa", "Solomon Islands", "Tonga", "Tuvalu", "Vanuatu", "American Samoa (USA)", "Cook Islands (New Zealand)", "French Polynesia (France)", "Guam (USA)",
                "New Caledonia (France)", "Niue (New Zealand)", "Norfolk Island (Australia)", "Northern Mariana Islands (USA)", "Pitcairn Islands (UK)", "Tokelau (New Zealand)",
                "Wake Island (USA)", "Wallis and Futuna (France)"};

        for (String s : europeCountries) {
            Country country = new Country();
            country.setName(s);
            try {
                country.setContinent(continentService.findContinentByName("Europe"));
            } catch (ContinentNotFoundException e) {
                e.getLocalizedMessage();
            }
            country.setActive(true);
            countryService.createCountry(country);
        }

        for (String s : asianCountries) {
            Country country = new Country();
            country.setName(s);
            try {
                country.setContinent(continentService.findContinentByName("Asia"));
            } catch (ContinentNotFoundException e) {
                e.getLocalizedMessage();
            }
            country.setActive(true);
            countryService.createCountry(country);
        }

        for (String s : africanCountries) {
            Country country = new Country();
            country.setName(s);
            try {
                country.setContinent(continentService.findContinentByName("Africa"));
            } catch (ContinentNotFoundException e) {
                e.getLocalizedMessage();
            }
            country.setActive(true);
            countryService.createCountry(country);
        }

        for (String s : australiaAndOceaniaCountries) {
            Country country = new Country();
            country.setName(s);
            try {
                country.setContinent(continentService.findContinentByName("Australia and Oceania"));
            } catch (ContinentNotFoundException e) {
                e.getLocalizedMessage();
            }
            country.setActive(true);
            countryService.createCountry(country);
        }

        for (String s : northAmericaCountries) {
            Country country = new Country();
            country.setName(s);
            try {
                country.setContinent(continentService.findContinentByName("North America"));
            } catch (ContinentNotFoundException e) {
                e.getLocalizedMessage();
            }
            country.setActive(true);
            countryService.createCountry(country);
        }

        for (String s : southAmericaCountries) {
            Country country = new Country();
            country.setName(s);
            try {
                country.setContinent(continentService.findContinentByName("South America"));
            } catch (ContinentNotFoundException e) {
                e.getLocalizedMessage();
            }
            country.setActive(true);
            countryService.createCountry(country);
        }
    }

    private void populateDBWithCities() throws ContinentNotFoundException {

        //Country lists by continent

        List<Country> EuropeanCountries = countryService.findAllCountriesByContinent(continentService.findContinentByName("Europe"));

        List<Country> AsianCountries = countryService.findAllCountriesByContinent(continentService.findContinentByName("Asia"));

        List<Country> AfricanCountries = countryService.findAllCountriesByContinent(continentService.findContinentByName("Africa"));

        List<Country> AustralianAndOceaniaCountries = countryService.findAllCountriesByContinent(continentService.findContinentByName("Australia and Oceania"));

        List<Country> NorthAmericaCountries = countryService.findAllCountriesByContinent(continentService.findContinentByName("North America"));

        List<Country> SouthAmericaCountries = countryService.findAllCountriesByContinent(continentService.findContinentByName("South America"));

        //For loops to create cities, giving random names with faker and assigning random country from lists.


        for (int i = 0; i < 100; i++) {
            City city = new City();
            city.setName(faker.address().cityName());
            city.setActive(true);
            int contentSelectorNumber = (int) Math.abs(Math.random() * 6);
            switch (contentSelectorNumber) {
                case 0 ->
                        city.setCountry(EuropeanCountries.get((int) Math.abs(Math.random() * EuropeanCountries.size())));
                case 1 ->
                        city.setCountry(AfricanCountries.get((int) Math.abs(Math.random() * AfricanCountries.size())));
                case 2 -> city.setCountry(AsianCountries.get((int) Math.abs(Math.random() * AsianCountries.size())));
                case 3 ->
                        city.setCountry(AustralianAndOceaniaCountries.get((int) Math.abs(Math.random() * AustralianAndOceaniaCountries.size())));
                case 4 ->
                        city.setCountry(NorthAmericaCountries.get((int) Math.abs(Math.random() * NorthAmericaCountries.size())));
                case 5 ->
                        city.setCountry(SouthAmericaCountries.get((int) Math.abs(Math.random() * SouthAmericaCountries.size())));
            }
            cityService.createCity(city);
        }
    }

    private void populateDBWithAirports() {
        for (int i = 0; i < 100; i++) {
            Airport airport = new Airport();
            airport.setActive(true);
            airport.setName(faker.name().name() + " Airport");
            airport.setCity(cityService.findAllCities().get((int) Math.abs(Math.random() * cityService.findAllCities().size())));
            airportService.createAirport(airport);
        }
    }

    private void populateDBWithHotels() {
        for (int i = 0; i<100; i++){
            Hotel hotel = new Hotel();
            hotel.setName(faker.name().name() + " Hotel");
            hotel.setCity(cityService.findAllCities().get((int) Math.abs(Math.random() * cityService.findAllCities().size())));
            hotel.setActive(true);
            int hotelStarPicker = (int)Math.abs(Math.random()*5);
            switch (hotelStarPicker){
                case 0 -> hotel.setHotelStandard(ONE_STAR);
                case 1 -> hotel.setHotelStandard(TWO_STARS);
                case 2 -> hotel.setHotelStandard(THREE_STARS);
                case 3 -> hotel.setHotelStandard(FOUR_STARS);
                case 4 -> hotel.setHotelStandard(FIVE_STARS);
            }
            hotel.setDescription(faker.lorem().sentence(20));
            hotelService.createHotel(hotel);
        }
        Hotel tent = new Hotel();
        tent.setName("Tent");
        tent.setHotelStandard(ONE_STAR);
        hotelService.createHotel(tent);
    }

    private void populateDBWithTrips() throws HotelNotFoundException {
        for (int i = 0; i<50; i++) {
            Airport departureAirport = airportService.findAllAirports().get((int) Math.abs(Math.random() * airportService.findAllAirports().size()));
            Airport destinationAirport = airportService.findAllAirports().get((int) Math.abs(Math.random() * airportService.findAllAirports().size()));
            Trip trip = new Trip();
            trip.setDepartureAirport(departureAirport);
            trip.setDepartureCity(departureAirport.getCity());
            trip.setArrivalAirport(destinationAirport);
            trip.setArrivalCity(destinationAirport.getCity());
            int hotelBasisPicker = (int)Math.abs(Math.random()*5);
            switch (hotelBasisPicker){
                case 0 -> trip.setHotelBasis(RO);
                case 1 -> trip.setHotelBasis(BB);
                case 2 -> trip.setHotelBasis(HB);
                case 3 -> trip.setHotelBasis(FB);
                case 4 -> trip.setHotelBasis(AI);
            }
            if(hotelService.findHotelsByCity(destinationAirport.getCity()).isEmpty()){
                trip.setArrivalHotel(hotelService.findHotelByName("Tent"));
                trip.setHotelBasis(RO);
            }else {
                trip.setArrivalHotel(hotelService.findHotelsByCity(destinationAirport.getCity()).get((int) Math.abs(Math.random()* hotelService.findHotelsByCity(destinationAirport.getCity()).size())));
            }
            Date depDate = faker.date().between(new Date(), java.util.Date.from(LocalDate.of(2023, 12, 31).atStartOfDay()
                    .atZone(ZoneId.systemDefault())
                    .toInstant()));
            int tripDuration = ((int)Math.abs(Math.random()*14))+1;
            trip.setDepartureDate(depDate);
            Calendar returnDate  = Calendar.getInstance();
            returnDate.setTime(depDate);
            returnDate.add(Calendar.DAY_OF_MONTH, tripDuration);
            trip.setReturnDate(returnDate.getTime());
            trip.setDurationInDays(tripDuration);
            double priceForAdult = faker.number().randomDouble(2,100, 5000);
            trip.setPriceForAdult(priceForAdult);
            trip.setPriceForChild(priceForAdult/1.2);
            trip.setNumberOfBedsForAdults(faker.number().numberBetween(1,5));
            trip.setNumberOfBedsForChildren(faker.number().numberBetween(1,5));
            trip.setPromoted(priceForAdult < 2000 && tripDuration > 7);
            trip.setActive(true);
            tripService.createTrip(trip);
        }
    }
}
