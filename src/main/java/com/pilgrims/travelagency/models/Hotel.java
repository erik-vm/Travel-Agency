package com.pilgrims.travelagency.models;


import com.pilgrims.travelagency.utils.Constants;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * School model
 *
 * @author Ott Pikk
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Hotel extends Auditable<String> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(updatable = false, nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String name;
    private enum hotelStandard {
        ONE_STAR,
        TWO_STARS,
        THREE_STARS,
        FOUR_STARS,
        FIVE_STARS
    };

    private String description;

    @ManyToMany
    @JoinColumn(name = "cityId",
                nullable = false,
                referencedColumnName = "id",
                foreignKey = @ForeignKey(name = "city_hotel_fk"))
    private String city;

    private boolean isActive;





}
