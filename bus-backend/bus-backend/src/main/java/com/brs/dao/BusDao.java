package com.brs.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brs.entity.Bus;
import org.springframework.data.jpa.repository.Query;

public interface BusDao extends JpaRepository<Bus,Integer>{

	List<Bus> findByBusType(String busType);

	Optional<Bus> findByBusName(String busName);

	@Query(" SELECT b FROM Bus b WHERE b.routeFrom =?1 and b.routeTo =?2and  b.date =?3")
	List<Bus> searchBus(String from , String to , Date date);


	@Query(" SELECT b FROM Bus b WHERE b.routeFrom =?1 and b.routeTo =?2 ")
	List<Bus> searchBus(String from , String to );
}
