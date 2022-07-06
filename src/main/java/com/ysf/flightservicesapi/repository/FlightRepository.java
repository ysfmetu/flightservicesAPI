package com.ysf.flightservicesapi.repository;

import com.ysf.flightservicesapi.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository  extends JpaRepository<Flight,Long> {
}
