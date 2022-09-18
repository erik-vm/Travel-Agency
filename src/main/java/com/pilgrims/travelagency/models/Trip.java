package com.pilgrims.travelagency.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Trip model
 *
 * @author Ott Pikk
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Trip extends Auditable<String> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(updatable = false, nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @OneToOne(cascade = CascadeType.MERGE)
    private City departureCity;

    @OneToOne(cascade = CascadeType.MERGE)
    private Airport departureAirport;

    @OneToOne(cascade = CascadeType.MERGE)
    private City arrivalCity;

    @OneToOne(cascade = CascadeType.MERGE)
    private Airport arrivalAirport;

    @OneToOne(cascade = CascadeType.MERGE)
    private Hotel arrivalHotel;

    @Enumerated(EnumType.STRING)
    private HotelBasis hotelBasis;

    private Date departureDate;
    private Date returnDate;
    private int durationInDays;

    private double priceForAdult;
    private double priceForChild;
    private double totalPrice;

    private int numberOfBedsForAdults;
    private int numberOfBedsForChildren;

    private boolean isActive;
    private boolean promoted;

    private int timesBooked;

    @ManyToMany(mappedBy = "tripsBooked")
    List<User> bookedByUsers = new ArrayList<>();





}
