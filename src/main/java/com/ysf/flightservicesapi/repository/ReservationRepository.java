package com.ysf.flightservicesapi.repository;

import com.ysf.flightservicesapi.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
