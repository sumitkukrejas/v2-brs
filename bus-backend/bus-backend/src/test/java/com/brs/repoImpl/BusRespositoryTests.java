package com.brs.repoImpl;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.brs.dao.BusDao;
import com.brs.entity.Bus;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BusRespositoryTests {

	@Autowired
	BusDao busDao; 

	@Test 
	@Order(1)
	@Rollback(value=false)
	public void saveBusTest() {
		Bus bus=new Bus(); 
		bus.setBusId(1); 
		bus.setArrivalTime(LocalTime.parse("10:10"));
		bus.setDepartureTime(LocalTime.parse("10:15"));
		bus.setAvaiableSeats(25);
		bus.setBusName("gug");
	    bus.setBusType("jjjj");
	    bus.setDriverName("hhhil");
	    bus.setRouteFrom("jjrrj");
	    bus.setRouteTo("fjf"); 
	    bus.setSeats(12); 
	    
	    busDao.save(bus);
	    Assertions.assertThat(bus.getBusId()).isEqualTo(1);
	}
	
	@Test
	@Order(2)
	public void getBusTest(){
		Bus bus= busDao.findById(1).get();
		Assertions.assertThat(bus.getBusId()).isEqualTo(1);
	} 
	
	@Test
	@Order(3)
	public void getListOfBusTest(){
		List<Bus> buses=busDao.findAll();
		Assertions.assertThat(buses.size()).isGreaterThan(0);
		}
	
	@Test
	@Order(4)
	@Rollback(value=false)
	public void updateBusTest() {
		Bus bus=busDao.findById(1).get();
		bus.setAvaiableSeats(24);
		Bus busUpdated=busDao.save(bus);
		Assertions.assertThat(busUpdated.getAvaiableSeats()).isEqualTo(24);
		
	}
	
	@Test
	@Order(5)
	@Rollback(value=false)
	public void deleteBusTest() {
		Bus bus=busDao.findById(1).get();
		busDao.delete(bus);
		Bus bus1=null; 
		Optional<Bus> optionalBus= busDao.findByBusName("gug");
		if(optionalBus.isPresent())
			bus1=optionalBus.get();
		Assertions.assertThat(bus1).isNull();
		}
	
}
