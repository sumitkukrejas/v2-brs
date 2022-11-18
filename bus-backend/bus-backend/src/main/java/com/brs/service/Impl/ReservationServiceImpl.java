package com.brs.service.Impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.brs.entity.Bus;
import com.brs.service.interfaces.IBusService;
import com.brs.service.interfaces.IReservationService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brs.dao.ReservationDao;
import com.brs.entity.Reservation;
import com.brs.exceptions.ReservationNotFoundException;

@Service

public class ReservationServiceImpl implements IReservationService {
	@Autowired
	ReservationDao reservationDao;

	@Autowired
	IBusService busService;
	
	
	@Override
	@SneakyThrows
	public Reservation addReservation(Reservation reservation) {
		int reserId = reservation.getReservationId();
		Optional<Reservation> reser = reservationDao.findById(reserId);
		if(!reser.isPresent())
		{
			reservationDao.save(reservation);
			return reservation;
		}
		else
		{
			throw new ReservationNotFoundException("Reservation ID exits");
		}

	}

	

	@Override
	@SneakyThrows
	public Reservation deleteReservation(int reservationId){
		
	
		Optional<Reservation> r = reservationDao.findById(reservationId);
		if(r.isPresent())
		{
			Reservation reservationdeleted = r.get();
			
			reservationDao.deleteById(reservationId);
			return reservationdeleted;
		}
		else {
			
			throw new ReservationNotFoundException("No resrevation with id : "+reservationId);
		}

	}

	@Override
	@SneakyThrows
	public Reservation viewReservation(int reservationId) {
		Optional<Reservation> res = reservationDao.findById(reservationId);
		if(res.isPresent())
		{
			return res.get();
		}
		else {
			
			throw new ReservationNotFoundException("No resrevation with id : "+reservationId);
		}
	}

	@Override
	public List<Reservation> viewAllReservation() {
		return reservationDao.findAll();
		
	}

	@Override
	@Transactional
	@SneakyThrows
	public Reservation updateReservation(Reservation reservation) {



		
		int reservationId = reservation.getReservationId();		
		Optional<Reservation> res = reservationDao.findById(reservationId);
		if(res.isPresent())
		{
			Reservation resToUpdate = res.get();
			
			resToUpdate.setDestination(reservation.getDestination());
			resToUpdate.setReservationDate(reservation.getReservationDate());
			resToUpdate.setReservationStatus(reservation.getReservationStatus());
			resToUpdate.setReservationTime(reservation.getReservationTime());
			resToUpdate.setReservationType(reservation.getReservationType());
			resToUpdate.setSource(reservation.getSource());
			resToUpdate.setBusId(reservation.getBusId());


//			if(reservation.getBus().getBusId()== resToUpdate.getBus().getBusId())
//			{
//				Bus bus = busService.updateBus(reservation.getBus());
//				resToUpdate.setBus(bus);
//			}
//			else {
//				resToUpdate.setBus(reservation.getBus());
//			}

			
			return resToUpdate;
			
				
		}
		else {
			throw new ReservationNotFoundException("reservation not found");
		}	
	}

	
	
	
}
