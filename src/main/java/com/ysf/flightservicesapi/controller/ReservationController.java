package com.ysf.flightservicesapi.controller;

import com.ysf.flightservicesapi.dto.CreateReservationRequest;
import com.ysf.flightservicesapi.dto.UpdateReservationRequest;
import com.ysf.flightservicesapi.model.Flight;
import com.ysf.flightservicesapi.model.Passenger;
import com.ysf.flightservicesapi.model.Reservation;
import com.ysf.flightservicesapi.repository.FlightRepository;
import com.ysf.flightservicesapi.repository.PassengerRepository;
import com.ysf.flightservicesapi.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class ReservationController {
    @Autowired
    public FlightRepository flightRepo;
    @Autowired
    public PassengerRepository passengerRepo;
    public ReservationRepository resRepo;

    @GetMapping("flights")
    public List<Flight>findFlights(@RequestParam("from") String from,@RequestParam("to") String to,
                                   @RequestParam("dateOfDeparture") @DateTimeFormat(pattern = "dd-MM-yyyy") Date departureDate){

        return flightRepo.findFlights(from, to, departureDate);
    }

    @PostMapping("reservations")
    @Transactional
    public Reservation SaveReservation(CreateReservationRequest request){
        Flight flight =flightRepo.findById(request.getFlightId()).get();

        Passenger passenger=new Passenger();
        passenger.setFirstName(request.getPassengerName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setEmail(request.getPassengerEmail());
        passenger.setPhone(request.getPassengerPhone());

        Passenger savedPassenger= passengerRepo.save(passenger);

        Reservation reservation =new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);

        return resRepo.save(reservation);


    }

    @GetMapping("reservations/{reservationId}")
    public Reservation findReservation(@PathVariable("reservationId") Long id){
        return resRepo.findById(id).get();
    }

    @PutMapping("reservations")
    public Reservation updateReservation(UpdateReservationRequest request){
        Reservation reservation=resRepo.findById(request.reservationId).get();
        reservation.setCheckedIn(request.isCheckIn());
        reservation.setNumberOfBags(request.getNumberOfBags());
    return resRepo.save(reservation);
    }
}
