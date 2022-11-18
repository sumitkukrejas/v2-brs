package com.brs.service.Impl;

import com.brs.dao.BusDao;
import com.brs.entity.Bus;
import com.brs.exceptions.BusNotFoundException;
import com.brs.service.interfaces.IBusService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class IbusServiceImplTest {
    @MockBean
    IbusServiceImpl busService;

    @BeforeEach @SneakyThrows
    void setUp()  {
        busList.add(bus);
        busList.add(bus1);
        busListbyTypeAC.add(bus);
        busListbyTypeAC.add(bus1); 
        busListbyTypeNonAC.add(bus2);
        Mockito.when(busService.addBus(bus)).thenReturn(bus);
        Mockito.when(busService.deleteBus(1)).thenReturn(bus);
        Mockito.when(busService.viewBus(1)).thenReturn(bus);
        Mockito.when(busService.viewAllBus()).thenReturn(busList);
        Mockito.when(busService.viewBusByType("AC")).thenReturn(busListbyTypeAC);
        Mockito.when(busService.viewAllBus()).thenReturn(busList);
        Mockito.when(busService.updateBus(bus)).thenReturn(bus1);
    }

    @Test
    void addBus() {
        Bus testbus = busService.addBus(bus);
        assertEquals(testbus,bus);
        assertNotEquals(testbus,bus1);
    }

    @Test
    void updateBus() throws BusNotFoundException {
        Bus testbus = busService.updateBus(bus);
        assertEquals(bus1,testbus);
        assertNotEquals(testbus,bus);
    }

    @Test
    void deleteBus() throws BusNotFoundException {
        Bus testbus = busService.deleteBus(1);
        assertEquals(bus,testbus);
        assertNotEquals(testbus,bus1);
    }

    @Test
    void viewBus() throws BusNotFoundException {
        Bus testbus = busService.viewBus(1);
        assertEquals(testbus,bus);
        assertNotEquals(testbus,bus1);

    }

    @Test
    void viewBusByType() {
        List<Bus> testBus = busService.viewBusByType("AC");
        assertEquals(testBus,busListbyTypeAC);
        assertNotEquals(testBus,busListbyTypeNonAC);

    }

    @Test
    void viewAllBus() {
        List<Bus> testBus = busService.viewAllBus();
        assertEquals(testBus,busList);
        assertNotEquals(testBus,busListbyTypeNonAC);
    }


    Bus bus = Bus.builder()
            .busId(1)
            .busName("kk")
            .busType("AC")
            .driverName("XYZ")
            .routeTo("DEL")
            .routeFrom("SGR")
            .departureTime(LocalTime.parse("10:10"))
            .arrivalTime(LocalTime.parse("09:00"))
            .avaiableSeats(30)
            .seats(50)
            .build();

    Bus bus1 = Bus.builder()
            .busId(2)
            .busName("kk")
            .busType("AC")
            .driverName("XYZ")
            .routeTo("DEL")
            .routeFrom("SGR")
            .departureTime(LocalTime.parse("10:10"))
            .arrivalTime(LocalTime.parse("09:00"))
            .avaiableSeats(30)
            .seats(50)
            .build();

    Bus bus2 = Bus.builder()
            .busId(3)
            .busName("kk")
            .busType("AC")
            .driverName("XYZ")
            .routeTo("DEL")
            .routeFrom("SGR")
            .departureTime(LocalTime.parse("10:10"))
            .arrivalTime(LocalTime.parse("09:00"))
            .avaiableSeats(30)
            .seats(50)
            .build();

    List<Bus> busList = new ArrayList<>();
    List<Bus> busListbyTypeAC = new ArrayList<>();
    List<Bus> busListbyTypeNonAC = new ArrayList<>();
}