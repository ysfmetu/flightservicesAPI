package com.ysf.flightservicesapi.dto;

import lombok.Data;

@Data
public class CreateReservationRequest {
    private Long flightId;
    private String passengerName;
    private String passengerLastName;
    private String passengerEmail;
    private String passengerPhone;
    private String cardNumber;
    private String expirationDate;
    private String securityCode;





}
