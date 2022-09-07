package com.pilgrims.travelagency.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * User model
 *
 * @author Ott Pikk
 */
@Data
@Entity
@EqualsAndHashCode
public class User extends Auditable<String> implements Serializable {
    private static final long serialVersionID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(updatable = false, nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String userName;
    private String password;

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;
    private LocalDate dateOfBirth;

    @OneToOne(cascade = CascadeType.MERGE)
    private Authority authority;

    private boolean isActive;
}
