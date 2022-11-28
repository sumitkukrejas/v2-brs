package com.brs.service.Impl;

import com.brs.dao.BusDao;
import com.brs.entity.Reservation;
import com.brs.exceptions.ReservationNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReservationServiceImplTest {

@MockBean
    private ReservationServiceImpl reservationDao;

@MockBean
private BusDao busDao;




    @BeforeEach
    void setUp() throws ReservationNotFoundException {

        reservationList.add(reservation);
        reservationList.add(reservation1);

        Mockito.when(reservationDao.addReservation(reservation)).thenReturn(reservation);
        Mockito.when(reservationDao.deleteReservation(1)).thenReturn(reservation);
        Mockito.when(reservationDao.viewReservation(1)).thenReturn(reservation);
        Mockito.when(reservationDao.viewAllReservation()).thenReturn(reservationList);
        Mockito.when(reservationDao.updateReservation(reservation)).thenReturn(reservation1);

    }

    @Test
   public void addReservationTest() {
        Reservation reser = reservationDao.addReservation(reservation);
        assertEquals(reser,reservation);
        assertNotEquals(reser,reservation1);

    }

    @Test
    void deleteReservationbyIdTest() throws ReservationNotFoundException {

        Reservation reser = reservationDao.deleteReservation(reservation.getReservationId());
        assertEquals(reser,reservation);
        assertNotEquals(reser,reservation1);


    }

    @Test
    void viewReservationTest() throws ReservationNotFoundException {

        Reservation reser = reservationDao.viewReservation(reservation.getReservationId());
        assertEquals(reser,reservation);
        assertNotEquals(reser,reservation1);
    }

    @Test
    void viewAllReservationTest() {

        List<Reservation> reserList = reservationDao.viewAllReservation();
        assertEquals(reservationList,reserList);
        assertNotEquals(reserList,reservationList2);

    }

    @Test
    void updateReservationTest() {
        Reservation reser = reservationDao.updateReservation(reservation);
        assertEquals(reser,reservation1);
        assertNotEquals(reser,reservation);
    }

    IbusServiceImplTest bst = new IbusServiceImplTest();

    Reservation reservation =
            Reservation.builder()
                    .reservationId(1)
                    .reservationDate(LocalDate.parse("2022-10-19"))
                    .reservationTime(LocalTime.parse("10:00:00"))
                    .reservationStatus("Done")
                    .reservationType("xyz")
                    .source("SGR")
                    .destination("DEL")
                    .bus(bst.bus1)
                    .build();
    Reservation reservation1 =
            Reservation.builder()
                    .reservationId(2)
                    .reservationDate(LocalDate.parse("2022-10-19"))
                    .reservationTime(LocalTime.parse("10:00:00"))
                    .reservationStatus("Done")
                    .reservationType("xyz")
                    .source("SGR")
                    .destination("DEL")
                    .bus(bst.bus2)
                    .build();


    List<Reservation> reservationList2 = new ArrayList<>();
    List<Reservation> reservationList = new ArrayList<>();

}