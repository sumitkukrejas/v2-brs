package com.brs.service.Implementation;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import com.brs.repository.IBusRepository;
import com.brs.service.interfaces.IBusService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.brs.entity.Bus;
import com.brs.exceptions.BusNotFoundException;
@Service
@Transactional
public class BusServiceImpl implements IBusService {

	@Autowired
	IBusRepository busRepository;

	@Override
	@SneakyThrows
	public Bus addBus(Bus bus) {
		int id = bus.getBusId();
		Optional<Bus> b = busRepository.findById(id);
		if (!b.isPresent()) {
			return busRepository.save(bus);
		} else {
			throw new BusNotFoundException("bus id exits");
		}


	}

	@Override
	@SneakyThrows
	public Bus updateBus(Bus bus) {

		int busId = bus.getBusId();
		Optional<Bus> res = busRepository.findById(busId);
		if (res.isPresent()) {
			Bus existBus = res.get();
			existBus.setBusName(bus.getBusName());
			existBus.setRouteFrom(bus.getRouteFrom());
			existBus.setBusType(bus.getBusType());
			existBus.setRouteTo(bus.getRouteTo());
			existBus.setArrivalDate(bus.getArrivalDate());
			existBus.setDepartureDate(bus.getDepartureDate());
			existBus.setDepartureTime(bus.getDepartureTime());
			existBus.setArrivalTime(bus.getArrivalTime());
			existBus.setSeats(bus.getSeats());
			existBus.setAvailableSeats(bus.getAvailableSeats());
			return existBus;
		} else {
			throw new BusNotFoundException("CANT UPDATE BUS , CHECK ID");
		}
	}


	@Override
	@SneakyThrows
	public Bus deleteBus(int busId) {

		Bus br;
		Optional<Bus> b = busRepository.findById(busId);
		if (b.isPresent()) {
			br = b.get();
			busRepository.deleteById(busId);
			return br;
		} else {

			throw new BusNotFoundException("CANT DELETE BUS NOT FOUND ");
		}


	}

	@Override
	@SneakyThrows
	public Bus viewBus(int busId) {
		Optional<Bus> b = busRepository.findById(busId);
		if (b.isPresent()) {
			return b.get();
		} else {

			throw new BusNotFoundException("BUS NOT FOUND ");
		}
	}


	@Override
	public List<Bus> viewAllBus() {

		return busRepository.findAll();
	}

	@Override
	public List<Bus> searchBus(String from, String to, LocalDate departureDate) {
		return busRepository.searchBus(from, to, departureDate);
	}
}
