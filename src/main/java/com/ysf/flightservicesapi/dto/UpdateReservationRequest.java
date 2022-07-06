package com.ysf.flightservicesapi.dto;

import lombok.Data;

@Data
public class UpdateReservationRequest {
    public Long reservationId;
    public boolean checkIn;
    public int numberOfBags;
}
