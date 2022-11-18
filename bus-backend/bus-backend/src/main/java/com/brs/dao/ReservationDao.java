package com.brs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brs.entity.Reservation;

public interface ReservationDao extends JpaRepository<Reservation, Integer> {

}
