package com.pilgrims.travelagency.models;

import com.pilgrims.travelagency.utils.Constants;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Continents extends Auditable<String> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(updatable = false, nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id")
    private String name;

    private boolean isActive;
}
