package com.brs.service.interfaces;

import java.util.List;

import com.brs.entity.Reservation;
import com.brs.exceptions.BusNotFoundException;
import com.brs.exceptions.UnModifiableException;
import com.brs.exceptions.ReservationNotFoundException;

public interface IReservationService {
	Reservation addReservation(Reservation reservation);
	Reservation deleteReservation(int reservationId) throws ReservationNotFoundException;
	Reservation viewReservation(int reservationId) throws ReservationNotFoundException;
	List<Reservation> viewAllReservation();
	Reservation updateReservation(Reservation reservation) throws ReservationNotFoundException, UnModifiableException, BusNotFoundException;
}
