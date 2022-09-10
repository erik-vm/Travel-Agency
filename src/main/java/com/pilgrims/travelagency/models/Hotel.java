package com.pilgrims.travelagency.models;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * Hotel model
 *
 * @author Ott Pikk
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Hotel extends Auditable<String> implements Serializable {
    private static final long serialVersionID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(updatable = false, nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    private HotelStandard hotelStandard;

    private String description;

    @OneToOne(cascade = CascadeType.MERGE)
    private City city;

    private boolean isActive;
}
