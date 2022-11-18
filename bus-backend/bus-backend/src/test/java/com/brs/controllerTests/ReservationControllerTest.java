package com.brs.controllerTests;

import com.brs.controllers.ReservationController;
import com.brs.entity.Reservation;
import com.brs.service.Impl.ReservationServiceImpl;
import com.brs.service.interfaces.IBusService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@WebMvcTest(ReservationController.class)
@RunWith(SpringRunner.class)

class ReservationControllerTest {

    @MockBean
    ReservationServiceImpl reservationService;

    @MockBean
    IBusService busService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    @SneakyThrows
    void setUp() {
        allReserList.add(reservation);
        Mockito.when(reservationService.addReservation(reservation)).thenReturn(reservation);
        Mockito.when(reservationService.viewAllReservation()).thenReturn(allReserList);
        Mockito.when(reservationService.deleteReservation(1)).thenReturn(reservation);

    }

    @Test
    @WithMockUser(username = "user",password = "user" ,roles={"USER"})
    void addReservation() throws Exception {

        MvcResult mvcResult=  mockMvc.perform(MockMvcRequestBuilders.post("/addReservation")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"reservationId\": 9,\n" +
                        "    \"reservationStatus\": \"pending\",\n" +
                        "    \"reservationType\": \"pre\",\n" +
                        "    \"reservationDate\": null,\n" +
                        "    \"reservationTime\": \"10:15:00\",\n" +
                        "    \"source\": \"KASHMIR\",\n" +
                        "    \"destination\": \"KOLKATA\",\n" +
                        "    \"bus\": {\n" +
                        "        \"busId\": 100,\n" +
                        "        \"busName\": \"XYZ-ABC\",\n" +
                        "        \"driverName\": \"ABC\",\n" +
                        "        \"busType\": \"DEL\",\n" +
                        "        \"routeFrom\": \"KASHMIR\",\n" +
                        "        \"routeTo\": \"KOLKATA\",\n" +
                        "        \"arrivalTime\": \"10:10:10\",\n" +
                        "        \"departureTime\": \"12:00:00\",\n" +
                        "        \"seats\": 100,\n" +
                        "        \"avaiableSeats\": 1\n" +
                        "    }\n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();


    }

    @Test @SneakyThrows
    @WithMockUser(username = "admin",password = "admin" ,roles={"ADMIN"})
    void viewAllReservation() {
        mockMvc.perform(MockMvcRequestBuilders.get("/viewAllReservation"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test @SneakyThrows
    @WithMockUser(username = "user",password = "usere" ,roles={"USER"})
    void deleteReservation() {
        mockMvc.perform(MockMvcRequestBuilders.delete("/deleteReservation?reservationId=1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test @SneakyThrows
    @WithMockUser(username = "user",password = "usere" ,roles={"USER"})
    void viewReservation() {
        mockMvc.perform(MockMvcRequestBuilders.get("/viewReservation?reservationId=1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test @SneakyThrows
    @WithMockUser(username = "user",password = "usere" ,roles={"USER"})
    void updateReservation() {
        mockMvc.perform(MockMvcRequestBuilders.put("/updateReservation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"reservationId\": 9,\n" +
                                "    \"reservationStatus\": \"pending\",\n" +
                                "    \"reservationType\": \"pre\",\n" +
                                "    \"reservationDate\": null,\n" +
                                "    \"reservationTime\": \"10:15:00\",\n" +
                                "    \"source\": \"KASHMIR\",\n" +
                                "    \"destination\": \"KOLKATA\",\n" +
                                "    \"bus\": {\n" +
                                "        \"busId\": 100,\n" +
                                "        \"busName\": \"XYZ-ABC\",\n" +
                                "        \"driverName\": \"ABC\",\n" +
                                "        \"busType\": \"DEL\",\n" +
                                "        \"routeFrom\": \"KASHMIR\",\n" +
                                "        \"routeTo\": \"KOLKATA\",\n" +
                                "        \"arrivalTime\": \"10:10:10\",\n" +
                                "        \"departureTime\": \"12:00:00\",\n" +
                                "        \"seats\": 100,\n" +
                                "        \"avaiableSeats\": 1\n" +
                                "    }\n" +
                                "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    BusControllerTest bct = new BusControllerTest();
    Reservation reservation =
            Reservation.builder()
                    .reservationId(2)
                    .reservationDate(LocalDate.parse("2022-10-19"))
                    .reservationTime(LocalTime.parse("10:00:00"))
                    .reservationStatus("Done")
                    .reservationType("xyz")
                    .source("SGR")
                    .destination("DEL")
                    .bus(bct.bus)
                    .build();

    List<Reservation> allReserList = new ArrayList<>();
}