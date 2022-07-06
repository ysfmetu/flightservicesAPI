package com.ysf.flightservicesapi.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Passenger extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
