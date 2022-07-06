package com.ysf.flightservicesapi.model;

import lombok.Data;

import javax.persistence.Entity;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
public class Flight extends BaseEntity {
    private String flightNumber;
    private String operatingAirlines;
    private String departureCity;
    private String arrivalCity;
    private Date dateOfDeparture;
    private Timestamp estimatedDepartureTime;
}
