package com.ysf.flightservicesapi.repository;

import com.ysf.flightservicesapi.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
