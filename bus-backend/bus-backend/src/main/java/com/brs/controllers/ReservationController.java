package com.brs.controllers;

	import java.util.List;


	import com.brs.exceptions.BusNotFoundException;
	import com.brs.exceptions.UnModifiableException;

	import com.brs.service.Impl.ReservationServiceImpl;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;

import com.brs.entity.Reservation;
import com.brs.exceptions.ReservationNotFoundException;


@RestController
	public class ReservationController {
		@Autowired
		ReservationServiceImpl reservationService;
		
		
		@PostMapping(value = "/addReservation")
		public Reservation addReservation(@RequestBody Reservation reservation) {
			return reservationService.addReservation(reservation);
			
		}
		
		@GetMapping("/viewAllReservation")
		public List<Reservation> viewAllReservation(){
			return reservationService.viewAllReservation();
		}
		
		@DeleteMapping("/deleteReservation")
		public Reservation deleteReservation(@RequestParam int reservationId) throws ReservationNotFoundException
		{
			return reservationService.deleteReservation(reservationId);
		}
		
		@GetMapping("/viewReservation")
		public Reservation viewReservation(@RequestParam int reservationId) throws ReservationNotFoundException
		{
			return reservationService.viewReservation(reservationId);
		}
		@PutMapping("/updateReservation")
		public Reservation updateReservation(@RequestBody Reservation reservation) throws ReservationNotFoundException, UnModifiableException, BusNotFoundException {
			return reservationService.updateReservation(reservation );
			
		}
	
		
	}


