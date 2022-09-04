package com.pilgrims.travelagency.utils;

/**
 * Static variables used in the application
 *
 * @author Ott Pikk
 */
public class Constants {
    public static class Audit {
        public static final String DEFAULT_AUDITOR = "SYSTEM";
    }

    public static class Security {
        public static final String AUTHORITY_ADMIN = "ROLE_ADMIN";
        public static final String AUTHORITY_CUSTOMER= "ROLE_CUSTOMER";
        public static final String AUTHORITY_GUEST = "ROLE_GUEST";
    }

    public static class HotelStandard {
        public static final String HOTEL_ONE = "ONE_STAR";
        public static final String HOTEL_TWO = "TWO_STAR";
        public static final String HOTEL_THREE = "THREE_STAR";
        public static final String HOTEL_FOUR = "FOUR_STAR";
        public static final String HOTEL_FIVE = "FIVE_STAR";
    }


}
