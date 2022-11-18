package com.brs.controllerTests;

import com.brs.controllers.BusController;
import com.brs.dao.BusDao;
import com.brs.entity.Bus;
import com.brs.exceptions.BusNotFoundException;
import com.brs.service.Impl.AdminDetailsService;
import com.brs.service.Impl.IbusServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@WebMvcTest(BusController.class)
@RunWith(SpringRunner.class)
class BusControllerTest {

    Bus bus = Bus.builder()
            .busId(1)
            .busName("kk")
            .busType("AC")
            .routeTo("DEL")
            .routeFrom("SGR")
            .departureTime(LocalTime.parse("10:10"))
            .arrivalTime(LocalTime.parse("09:00"))
            .avaiableSeats(30)
            .seats(50)
            .build();
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    IbusServiceImpl busService;

    @MockBean
    BusDao busDao;

    @BeforeEach @SneakyThrows
    void setUp() {



    }

    @Test
    @WithMockUser(username = "admin",password = "admin" ,roles={"ADMIN"})
    void addBus() throws Exception {

        Mockito.when(busService.addBus(bus)).thenReturn(bus);

       MvcResult mvcResult= mockMvc.perform(MockMvcRequestBuilders.post("/bus")
                .contentType(MediaType.APPLICATION_JSON)
                .content(" {\n" +
                        "    \"busId\": 1198,\n" +
                        "    \"busName\": \"XYZ-ABC\",\n" +
                        "    \"driverName\": \"ABC\",\n" +
                        "    \"busType\": \"DEL\",\n" +
                        "    \"routeFrom\": \"KASHMIR\",\n" +
                        "    \"routeTo\": \"KOLKATA\",\n" +
                        "    \"arrivalTime\": \"10:10:10\",\n" +
                        "    \"departureTime\": \"12:00:00\",\n" +
                        "    \"seats\": 100,\n" +
                        "    \"avaiableSeats\": 1\n" +
                        "}" ))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

       String actualJson = mvcResult.getResponse().getContentAsString();
        System.out.println(actualJson+"barkat");





    }

    @Test @WithMockUser(username = "admin",password = "admin" ,roles={"ADMIN"}) @SneakyThrows
    void updateBus() {
            Mockito.when(busService.updateBus(bus)).thenReturn(bus);
            mockMvc.perform(MockMvcRequestBuilders.put("/bus")
                .contentType(MediaType.APPLICATION_JSON)
                .content(" {\n" +
                        "    \"busId\": 1190,\n" +
                        "    \"busName\": \"XYZ-ABC\",\n" +
                        "    \"driverName\": \"ABC\",\n" +
                        "    \"busType\": \"DEL\",\n" +
                        "    \"routeFrom\": \"KASHMIR\",\n" +
                        "    \"routeTo\": \"KOLKATA\",\n" +
                        "    \"arrivalTime\": \"10:10:10\",\n" +
                        "    \"departureTime\": \"12:00:00\",\n" +
                        "    \"seats\": 10,\n" +
                        "    \"availableSeats\": 1\n" +
                        "}" )).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test@WithMockUser(username = "admin",password = "admin" ,roles={"ADMIN"}) @SneakyThrows
    void deleteBus() {
        Mockito.when(busService.deleteBus(1198)).thenReturn(bus);
     MvcResult result =    mockMvc.perform(MockMvcRequestBuilders.delete("/bus?busId=1198")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test @WithMockUser(username = "admin",password = "admin" ,roles={"ADMIN"})
    void viewBus() throws BusNotFoundException, Exception {
        Mockito.when(busService.viewBus(1198)).thenReturn(bus);
        MvcResult result =    mockMvc.perform(MockMvcRequestBuilders.get("/bus?busId=1198")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test @WithMockUser(username = "user",password = "user" ,roles={"USER"}) @SneakyThrows
    void viewBusByType() {
        allBusesByType.add(bus);
        Mockito.when(busService.viewBusByType("AC")).thenReturn(allBusesByType);
        mockMvc.perform(MockMvcRequestBuilders.get("/viewBusByType?busType=AC"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();


    }

    @Test @WithMockUser(username = "user",password = "user" ,roles={"USER"}) @SneakyThrows
    void viewAllBus() {

        allBuses.add(bus);
        Mockito.when(busService.viewAllBus()).thenReturn(allBuses);
        mockMvc.perform(MockMvcRequestBuilders.get("/buses"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    }

    List<Bus> allBuses = new ArrayList<>();

    List<Bus> allBusesByType = new ArrayList<>();



}