package com.brs.service.Impl;

import com.brs.entity.Feedback;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class IFeedBackServiceImplTest {
    @MockBean
    IFeedBackServiceImpl feedBackService;

    @BeforeEach
    @SneakyThrows
    void setUp() {
        feedbackList.add(feedback1);
        feedbackList.add(feedback2);

        Mockito.when(feedBackService.addFeedBack(feedback1)).thenReturn(feedback1);
        Mockito.when(feedBackService.updateFeedBack(feedback1)).thenReturn(feedback2);
        Mockito.when(feedBackService.viewFeedBack(feedback1.getFeedBackId())).thenReturn(feedback1);
        Mockito.when(feedBackService.viewAllFeedBack()).thenReturn(feedbackList);

    }

    @Test
    @SneakyThrows
    void addFeedBack() {
        Feedback testFeedback = feedBackService.addFeedBack(feedback1);
        assertEquals(testFeedback,feedback1);
        assertNotEquals(testFeedback,feedback2);
    }

    @Test
    @SneakyThrows
    void updateFeedBack() {
        Feedback testFeedback = feedBackService.updateFeedBack(feedback1);
        assertEquals(testFeedback,feedback2);
        assertNotEquals(testFeedback,feedback1);
    }

    @Test
    @SneakyThrows
    void viewFeedBack() {
        Feedback testFeedback = feedBackService.viewFeedBack(feedback1.getFeedBackId());
        assertEquals(testFeedback,feedback1);
        assertNotEquals(testFeedback,feedback2);
    }

    @Test
    @SneakyThrows
    void viewAllFeedBack() {
       List <Feedback> testFeedbackList = feedBackService.viewAllFeedBack();
        assertEquals(testFeedbackList,feedbackList);
        assertNotEquals(testFeedbackList,feedbackList2);
    }

    List<Feedback> feedbackList = new ArrayList<>();
    IbusServiceImplTest bst = new IbusServiceImplTest();
    UsersServiceImplTest ust = new UsersServiceImplTest();

    Feedback feedback1 = Feedback.builder()
            .bus(bst.bus1)
            .users(ust.user1)
            .comments("very good service")
            .driverRating(5)
            .feedBackId(1)
            .feedbackdate(LocalDate.parse("2022-10-10"))
            .serviceRating(3)
            .overallRating(4)
            .build();

    Feedback feedback2 = Feedback.builder()
            .bus(bst.bus2)
            .users(ust.user2)
            .comments("very good service")
            .driverRating(5)
            .feedBackId(2)
            .feedbackdate(LocalDate.parse("2022-10-10"))
            .serviceRating(3)
            .overallRating(4)
            .build();

    List<Feedback> feedbackList2 = new ArrayList<>();
}