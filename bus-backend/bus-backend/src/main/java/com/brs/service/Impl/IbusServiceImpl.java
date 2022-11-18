package com.brs.service.Impl;



import java.util.Date;
import java.util.List;
import java.util.Optional;


import com.brs.service.interfaces.IBusService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.brs.dao.BusDao;
import com.brs.entity.Bus;
import com.brs.exceptions.BusNotFoundException;

@Service
@Transactional
public class IbusServiceImpl implements IBusService {

	@Autowired
	BusDao busDao;

	@Override
	@SneakyThrows
	public Bus addBus(Bus bus) {
		int id = bus.getBusId();
		Optional<Bus> b = busDao.findById(id);
		if (!b.isPresent()) {
			return busDao.save(bus);
		} else {
			throw new BusNotFoundException("bus id exits");
		}


	}

	@Override
	@SneakyThrows
	public Bus updateBus(Bus bus) {

		int busId = bus.getBusId();
		Optional<Bus> res = busDao.findById(busId);
		if (res.isPresent()) {
			Bus existBus = res.get();
			existBus.setBusName(bus.getBusName());
//			existBus.setDriverName(bus.getDriverName());
			existBus.setRouteFrom(bus.getRouteFrom());
			existBus.setBusType(bus.getBusType());
			existBus.setRouteTo(bus.getRouteTo());
			existBus.setArrivalTime(bus.getArrivalTime());
			existBus.setDepartureTime(bus.getDepartureTime());
			existBus.setSeats(bus.getSeats());
			existBus.setAvaiableSeats(bus.getAvaiableSeats());
			return existBus;
		} else {
			throw new BusNotFoundException("CANT UPDATE BUS , CHECK ID");
		}
	}


	@Override
	@SneakyThrows
	public Bus deleteBus(int busId) {

		Bus br;
		Optional<Bus> b = busDao.findById(busId);
		if (b.isPresent()) {
			br = b.get();
			busDao.deleteById(busId);
			return br;
		} else {

			throw new BusNotFoundException("CANT DELETE BUS NOT FOUND ");
		}


	}

	@Override
	@SneakyThrows
	public Bus viewBus(int busId) {
		Optional<Bus> b = busDao.findById(busId);
		if (b.isPresent()) {
			return b.get();
		} else {

			throw new BusNotFoundException("BUS NOT FOUND ");
		}
	}

	@Override
	@SneakyThrows
	public List<Bus> viewBusByType(String busType) {

		return busDao.findByBusType(busType);
	}

	@Override
	public List<Bus> viewAllBus() {

		return busDao.findAll();
	}

	@Override
	public List<Bus> searchBus(String from, String to, Date date) {
		return busDao.searchBus(from, to, date);
	}
	@Override
	public List<Bus> searchBus(String from, String to) {
		return busDao.searchBus(from, to);
	}

}
