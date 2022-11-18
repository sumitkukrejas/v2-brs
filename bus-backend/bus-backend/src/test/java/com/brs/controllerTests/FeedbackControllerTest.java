package com.brs.controllerTests;

import com.brs.controllers.FeedbackController;
import com.brs.service.Impl.IFeedBackServiceImpl;
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

@WebMvcTest(FeedbackController.class)
@RunWith(SpringRunner.class)
class FeedbackControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IFeedBackServiceImpl feedBackService;

    @BeforeEach
    void setUp() {
    }

    @Test
    @SneakyThrows
    @WithMockUser(username = "user",password = "user" ,roles={"USER"})
    void addFeedBack() {
        mockMvc.perform(MockMvcRequestBuilders.post("/addFeedback")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"feedBackId\": 1,\n" +
                        "    \"driverRating\": 5,\n" +
                        "    \"serviceRating\": 5,\n" +
                        "    \"overallRating\": 5,\n" +
                        "    \"comments\": \"good\",\n" +
                        "    \"feedbackdate\": \"2022-10-10\",\n" +
                        "    \"users\": {\n" +
                        "        \"userLoginId\": 1,\n" +
                        "        \"userName\": \"abcd\",\n" +
                        "        \"password\": \"abcd12345\",\n" +
                        "        \"firstName\": \"abcd\",\n" +
                        "        \"lastName\": \"abcd\",\n" +
                        "        \"contact\": 7006079324,\n" +
                        "        \"email\": \"bar@gmail.com\",\n" +
                        "        \"reservation\": {\n" +
                        "            \"reservationId\": 19,\n" +
                        "            \"reservationStatus\":\"done\",\n" +
                        "            \"reservationType\": \"jkj\",\n" +
                        "            \"reservationDate\": \"2022-10-10\",\n" +
                        "            \"reservationTime\": \"10:10:10\",\n" +
                        "            \"source\": \"ksr\",\n" +
                        "            \"destination\":\"jkj\",\n" +
                        "            \"bus\": {\n" +
                        "                \"busId\": 190,\n" +
                        "                \"busName\": \"abrl\",\n" +
                        "                \"driverName\": \"fef\",\n" +
                        "                \"busType\": \"AC\",\n" +
                        "                \"routeFrom\": \"ksh\",\n" +
                        "                \"routeTo\": \"mkk\",\n" +
                        "                \"arrivalTime\": \"10:00:00\",\n" +
                        "                \"departureTime\": \"10:00:00\",\n" +
                        "                \"seats\": 9,\n" +
                        "                \"avaiableSeats\": 1\n" +
                        "            }\n" +
                        "        }\n" +
                        "    },\n" +
                        "    \"bus\": {\n" +
                        "        \"busId\": 190,\n" +
                        "        \"busName\": \"abrl\",\n" +
                        "        \"driverName\": \"fef\",\n" +
                        "        \"busType\": \"AC\",\n" +
                        "        \"routeFrom\": \"ksh\",\n" +
                        "        \"routeTo\": \"mkk\",\n" +
                        "        \"arrivalTime\": \"10:00:00\",\n" +
                        "        \"departureTime\": \"10:00:00\",\n" +
                        "        \"seats\": 9,\n" +
                        "        \"avaiableSeats\": 1\n" +
                        "    }\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    @SneakyThrows
    @WithMockUser(username = "user",password = "user" ,roles={"USER"})
    void updateFeedBack() {
        mockMvc.perform(MockMvcRequestBuilders.put("/updateFeedback")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"feedBackId\": 1,\n" +
                        "    \"driverRating\": 5,\n" +
                        "    \"serviceRating\": 5,\n" +
                        "    \"overallRating\": 5,\n" +
                        "    \"comments\": \"good\",\n" +
                        "    \"feedbackdate\": \"2022-10-10\",\n" +
                        "    \"users\": {\n" +
                        "        \"userLoginId\": 1,\n" +
                        "        \"userName\": \"abcd\",\n" +
                        "        \"password\": \"abcd12345\",\n" +
                        "        \"firstName\": \"abcd\",\n" +
                        "        \"lastName\": \"abcd\",\n" +
                        "        \"contact\": 7006079324,\n" +
                        "        \"email\": \"bar@gmail.com\",\n" +
                        "        \"reservation\": {\n" +
                        "            \"reservationId\": 19,\n" +
                        "            \"reservationStatus\":\"done\",\n" +
                        "            \"reservationType\": \"jkj\",\n" +
                        "            \"reservationDate\": \"2022-10-10\",\n" +
                        "            \"reservationTime\": \"10:10:10\",\n" +
                        "            \"source\": \"ksr\",\n" +
                        "            \"destination\":\"jkj\",\n" +
                        "            \"bus\": {\n" +
                        "                \"busId\": 190,\n" +
                        "                \"busName\": \"abrl\",\n" +
                        "                \"driverName\": \"fef\",\n" +
                        "                \"busType\": \"AC\",\n" +
                        "                \"routeFrom\": \"ksh\",\n" +
                        "                \"routeTo\": \"mkk\",\n" +
                        "                \"arrivalTime\": \"10:00:00\",\n" +
                        "                \"departureTime\": \"10:00:00\",\n" +
                        "                \"seats\": 9,\n" +
                        "                \"avaiableSeats\": 1\n" +
                        "            }\n" +
                        "        }\n" +
                        "    },\n" +
                        "    \"bus\": {\n" +
                        "        \"busId\": 190,\n" +
                        "        \"busName\": \"abrl\",\n" +
                        "        \"driverName\": \"fef\",\n" +
                        "        \"busType\": \"AC\",\n" +
                        "        \"routeFrom\": \"ksh\",\n" +
                        "        \"routeTo\": \"mkk\",\n" +
                        "        \"arrivalTime\": \"10:00:00\",\n" +
                        "        \"departureTime\": \"10:00:00\",\n" +
                        "        \"seats\": 9,\n" +
                        "        \"availableSeats\": 1\n" +
                        "    }\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @SneakyThrows
    @WithMockUser(username = "user",password = "user" ,roles={"USER"})
    void viewFeedBack() {
        mockMvc.perform(MockMvcRequestBuilders.get("/viewFeedback?feedBackId=1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @SneakyThrows
    @WithMockUser(username = "user",password = "user" ,roles={"USER"})
    void viewAllFeedBack() {
        mockMvc.perform(MockMvcRequestBuilders.get("/viewAllFeedback"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}