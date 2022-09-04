package com.pilgrims.travelagency.models;

import org.springframework.beans.propertyeditors.CurrencyEditor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity

public class Trip {
@Id
@GeneratedValue
    private String city;
    private String airport;
    private Date departure;
    private Date returnDate;
    private Number numberOfDays;
    private String tripType;
    private Number adultPrice;
    private Number childPrice;
    private Number nrOfBedsAdult;
    private Number nrOfBedsChild;
    private String purchaseOfTrip;










}
