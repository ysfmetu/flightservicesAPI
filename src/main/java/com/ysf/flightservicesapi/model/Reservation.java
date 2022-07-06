package com.ysf.flightservicesapi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Reservation extends BaseEntity {
    private Boolean checkedIn;
    private int numberOfBags;
    @OneToOne
    private Flight flight;
    @OneToOne
    private Passenger passenger;
}
