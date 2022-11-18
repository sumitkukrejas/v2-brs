package com.brs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brs.entity.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation,Integer> {
	
}
