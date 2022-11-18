package com.brs.service.interfaces;

import java.util.List;

import com.brs.entity.Reservation;
import com.brs.exceptions.BusNotFoundException;
import com.brs.exceptions.UnModifiableException;
import com.brs.exceptions.ReservationNotFoundException;

public interface IReservationService {
	public Reservation addReservation(Reservation reservation);
	public Reservation deleteReservation(int reservationId) throws ReservationNotFoundException;
	public Reservation viewReservation(int reservationId) throws ReservationNotFoundException;
	public List<Reservation> viewAllReservation();
	public Reservation updateReservation(Reservation reservation) throws ReservationNotFoundException, UnModifiableException, BusNotFoundException;
}
