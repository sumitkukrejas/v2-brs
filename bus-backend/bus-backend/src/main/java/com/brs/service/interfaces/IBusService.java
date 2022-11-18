package com.brs.service.interfaces;



import java.util.Date;
import java.util.List;
import java.util.Optional;



import com.brs.entity.Bus;
import com.brs.exceptions.BusNotFoundException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;



public interface IBusService {
    @SneakyThrows
    public Bus addBus(Bus bus);
    public Bus updateBus(Bus bus) throws BusNotFoundException;
    public Bus deleteBus(int busId) throws BusNotFoundException;
    public Bus viewBus(int busId) throws BusNotFoundException;
    public List<Bus> viewBusByType(String BusType);
    public List<Bus> viewAllBus();
    //search for bus
    public List<Bus> searchBus(String from , String to , Date date);
    public List<Bus> searchBus(String from , String to);
}