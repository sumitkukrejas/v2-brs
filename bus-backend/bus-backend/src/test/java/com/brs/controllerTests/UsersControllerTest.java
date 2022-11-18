package com.brs.controllerTests;

import com.brs.controllers.UsersController;
import com.brs.service.Impl.UsersServiceImpl;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(UsersController.class)
@RunWith(SpringRunner.class)
class UsersControllerTest {

    @MockBean
    UsersServiceImpl usersService;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {

    }

    @Test
    @SneakyThrows
    @WithMockUser(username = "user",password = "user" ,roles={"USER"})
    void addUsers() {

        mockMvc.perform(MockMvcRequestBuilders.post("/addUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"userLoginId\": 9,\n" +
                        "    \"userName\": \"ABC\",\n" +
                        "    \"password\": \"ZYZ12345\",\n" +
                        "    \"firstName\": \"ZYZ\",\n" +
                        "    \"lastName\": \"ZYZ\",\n" +
                        "    \"contact\": \"7006079324\" ,\n" +
                        "    \"email\": \"ZYZ@GMAIL.COM\",\n" +
                        "    \"reservation\": {\n" +
                        "        \"reservationId\": 190,\n" +
                        "        \"reservationStatus\": \"ZYZ\",\n" +
                        "        \"reservationType\": \"ZYZ\",\n" +
                        "        \"reservationDate\":\"2022-10-10\",\n" +
                        "        \"reservationTime\":\"10:10:10\",\n" +
                        "        \"source\": \"ZYZ\",\n" +
                        "        \"destination\": \"ZYZ\",\n" +
                        "        \"bus\": {\n" +
                        "            \"busId\": 10,\n" +
                        "            \"busName\": \"ABC\",\n" +
                        "            \"driverName\": \"ABC\",\n" +
                        "            \"busType\": \"ABC\",\n" +
                        "            \"routeFrom\": \"ABC\",\n" +
                        "            \"routeTo\": \"ABC\",\n" +
                        "            \"arrivalTime\": \"10:10:10\",\n" +
                        "            \"departureTime\": \"12:00:00\",\n" +
                        "            \"seats\": 30,\n" +
                        "            \"avaiableSeats\": 2\n" +
                        "        }\n" +
                        "    }\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    @SneakyThrows
    @WithMockUser(username = "user",password = "user" ,roles={"USER"})
    void viewUsers() {
        mockMvc.perform(MockMvcRequestBuilders.get("/viewUser?userId=1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @SneakyThrows
    @WithMockUser(username = "user",password = "user" ,roles={"USER"})
    void viewAllUsers() {
        mockMvc.perform(MockMvcRequestBuilders.get("/viewAllUsers"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @SneakyThrows
    @WithMockUser(username = "admin",password = "admin" ,roles={"ADMIN"})
    void deleteUser() {
        mockMvc.perform(MockMvcRequestBuilders.delete("/deleteUser?userId=1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @SneakyThrows
    @WithMockUser(username = "admin",password = "admin" ,roles={"ADMIN"})
    void updateUser() {
        mockMvc.perform(MockMvcRequestBuilders.put("/updateUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"userLoginId\": 9,\n" +
                        "    \"userName\": \"ABC\",\n" +
                        "    \"password\": \"ZYZ12345\",\n" +
                        "    \"firstName\": \"ZYZ\",\n" +
                        "    \"lastName\": \"ZYZ\",\n" +
                        "    \"contact\": \"7006079324\" ,\n" +
                        "    \"email\": \"ZYZ@GMAIL.COM\",\n" +
                        "    \"reservation\": {\n" +
                        "        \"reservationId\": 190,\n" +
                        "        \"reservationStatus\": \"ZYZ\",\n" +
                        "        \"reservationType\": \"ZYZ\",\n" +
                        "        \"reservationDate\":\"2022-10-10\",\n" +
                        "        \"reservationTime\":\"10:10:10\",\n" +
                        "        \"source\": \"ZYZ\",\n" +
                        "        \"destination\": \"ZYZ\",\n" +
                        "        \"bus\": {\n" +
                        "            \"busId\": 10,\n" +
                        "            \"busName\": \"ABC\",\n" +
                        "            \"driverName\": \"ABC\",\n" +
                        "            \"busType\": \"ABC\",\n" +
                        "            \"routeFrom\": \"ABC\",\n" +
                        "            \"routeTo\": \"ABC\",\n" +
                        "            \"arrivalTime\": \"10:10:10\",\n" +
                        "            \"departureTime\": \"12:00:00\",\n" +
                        "            \"seats\": 30,\n" +
                        "            \"avaiableSeats\": 2\n" +
                        "        }\n" +
                        "    }\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}