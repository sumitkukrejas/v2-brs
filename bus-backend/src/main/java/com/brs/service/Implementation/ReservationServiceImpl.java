package com.brs.service.Implementation;

import java.util.List;
import java.util.Optional;

import com.brs.repository.IReservationRepository;
import com.brs.service.interfaces.IBusService;
import com.brs.service.interfaces.IReservationService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.brs.entity.Reservation;
import com.brs.exceptions.ReservationNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationServiceImpl implements IReservationService {
	@Autowired
	IReservationRepository reservationRepository;

	@Autowired
	IBusService busService;
	
	
	@Override
	@SneakyThrows
	public Reservation addReservation(Reservation reservation) {
		int reserId = reservation.getReservationId();
		Optional<Reservation> reser = reservationRepository.findById(reserId);
		if(!reser.isPresent())
		{
			reservationRepository.save(reservation);
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
		
	
		Optional<Reservation> r = reservationRepository.findById(reservationId);
		if(r.isPresent())
		{
			Reservation reservationdeleted = r.get();
			
			reservationRepository.deleteById(reservationId);
			return reservationdeleted;
		}
		else {
			
			throw new ReservationNotFoundException("No resrevation with id : "+reservationId);
		}

	}

	@Override
	@SneakyThrows
	public Reservation viewReservation(int reservationId) {
		Optional<Reservation> res = reservationRepository.findById(reservationId);
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
		return reservationRepository.findAll();
		
	}

	@Override
	@Transactional
	@SneakyThrows
	public Reservation updateReservation(Reservation reservation) {



		
		int reservationId = reservation.getReservationId();		
		Optional<Reservation> res = reservationRepository.findById(reservationId);
		if(res.isPresent())
		{
			Reservation resToUpdate = res.get();
			
			resToUpdate.setDestination(reservation.getDestination());
			resToUpdate.setReservationDate(reservation.getReservationDate());
			resToUpdate.setReservationTime(reservation.getReservationTime());
			resToUpdate.setSource(reservation.getSource());
			resToUpdate.setPassenger(reservation.getPassenger());
			resToUpdate.setBus(reservation.getBus());


//			if(reservation.getBus().getBusId() == resToUpdate.getBus().getBusId())
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
