package com.pilgrims.travelagency.utils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity

public enum Continents {
        NORTH_AMERICA,
        SOUTH_AMERICA,
        EUROPE,
        ASIA,
        AUSTRALIA,
        AFRICA,
        ANTARCTICA;
        @GeneratedValue
        @Id
        @Column(name = "id", nullable = false)
        private Long id;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }
}

