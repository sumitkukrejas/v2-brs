package com.brs.service.interfaces;



import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;

import com.brs.entity.Bus;
import com.brs.exceptions.BusNotFoundException;
import lombok.SneakyThrows;



public interface IBusService {
    
    Bus addBus(Bus bus);
    Bus updateBus(Bus bus) throws BusNotFoundException;
    Bus deleteBus(int busId) throws BusNotFoundException;
    Bus viewBus(int busId) throws BusNotFoundException;
    List<Bus> viewAllBus();
    List<Bus> searchBus(String from , String to , LocalDate departureDate);
}